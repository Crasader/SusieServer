package com.game.model.battle;

import com.core.math.Vector2;
import com.game.action.ActionManager;
import com.game.action.BasicAction;
import com.game.action.IActionCallback;
import com.game.action.MoveRoundAction;
import com.game.action.MoveToAction;
import com.game.action.RotationToAction;
import com.game.move.Move2D;
import com.proto.SceneObjMove.E_SceneObjMoveS;
import com.proto.SceneObjMove.MseSceneObjMove;

public class MoveControl {
	public enum MoveControlS{
		STOP,//停止
		STOP_AND_ROTATE,//原地转
		MOVE,//移动不转向
		MOVE_AND_ROTATE,//移动并转向
	}
	
	private MoveControlS state;
	private ABattleNode battleNode;
	private Move2D move;
	private BasicAction currentAction;
	private MseSceneObjMove.Builder sceneObjMoveBuilder;
	public MoveControl(ABattleNode battleNode) {
		state = MoveControlS.STOP;
		this.battleNode = battleNode;	
		this.move = battleNode.getMove();
		sceneObjMoveBuilder = MseSceneObjMove.newBuilder();
	}

	public void setUID(String uid) {
		sceneObjMoveBuilder.setUid(uid);
	}
	
	public MseSceneObjMove getCurrentMseSceneObjMove(){
		return sceneObjMoveBuilder.build();
	}
	
	public void setStateStop(){
		state = MoveControlS.STOP;
		if(null != currentAction){
			currentAction.setIsDelete(true);
			currentAction = null;
		}
		move.setSpeed(0.0f);
		move.setDegreeSpeed(0.0f);
		move.makeDegreeMin();		
		updateMseSceneObjMove(E_SceneObjMoveS.STOP , getEndTime(0.0f) ,move.getPos(),move.getDegree(), move.getDegree());
	}
	
	public void setStateStopAndRotate(float lastTime,float degreeSpeed , IActionCallback actionCallback){
		setStateStop();
		state = MoveControlS.STOP_AND_ROTATE;
		move.setSpeed(0.0f);
		move.setDegreeSpeed(degreeSpeed);
		float targetDegree = move.getDegree() + move.getDegreeSpeed()*lastTime;
		currentAction = new RotationToAction(targetDegree, lastTime);
		ActionManager.GetInstance().RunAction(battleNode, currentAction, actionCallback);		
		updateMseSceneObjMove(E_SceneObjMoveS.STOP_AND_ROTATE, getEndTime(lastTime), move.getPos(), targetDegree , move.getDegree() );
	}
	
	
	public void setStateMove(float lastTime ,float speed, IActionCallback actionCallback){
		setStateStop();
		state = MoveControlS.MOVE;
		move.setSpeed(speed);
		Vector2 targetPos = move.getPosWhenMove(lastTime);
		currentAction = new MoveToAction(targetPos, lastTime);
		ActionManager.GetInstance().RunAction(battleNode, currentAction, actionCallback);
		updateMseSceneObjMove(E_SceneObjMoveS.MOVE, getEndTime(lastTime) , targetPos, move.getDegree() , move.getDegree());
	}
	
	public void setStateMoveAndRotate(float lastTime ,float speed , float degreeSpeed , IActionCallback actionCallback){
		setStateStop();
		state = MoveControlS.MOVE_AND_ROTATE;
		//此处把这个移动转化成了圆周运动，粗略的转化。前后端一致就行，玩家不会介意。
		move.setSpeed(speed);
		move.setDegreeSpeed(degreeSpeed);
		float targetCenterDegree = move.getCenterDegree() + move.getCenterDegreeSpeed()*lastTime;
		currentAction = new MoveRoundAction(targetCenterDegree, lastTime);
		ActionManager.GetInstance().RunAction(battleNode, currentAction, actionCallback);
		updateMseSceneObjMove(E_SceneObjMoveS.MOVE_AND_ROTATE, getEndTime(lastTime), move.getCenterPos(), targetCenterDegree, move.getCenterDegree());
	}
	
	private void updateMseSceneObjMove(E_SceneObjMoveS state , long endTime , Vector2 targetPos , float targetDegree , float currentDegree){
		sceneObjMoveBuilder.setStatus(state)
		.setPosX(targetPos.x)
		.setPosY(targetPos.y)
		.setCurrentDegree(currentDegree)
		.setTargetDegree(targetDegree)
		.setEndTime(endTime);
	}

	private long getEndTime(float lastTime){
		return System.currentTimeMillis() + (int)(lastTime * 1000);
	}
}
