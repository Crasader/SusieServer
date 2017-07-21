package com.game.model.battle;

import org.apache.logging.log4j.LogManager;

import com.core.account.AccountData;
import com.core.account.AccountManager;
import com.core.math.Vector2;
import com.game.action.IActionCallback;
import com.game.db.DBManager;
import com.game.db.SceneNodeDBCollect.SceneNodeDB;
import com.game.model.BattleModel;
import com.google.protobuf.MessageLite;
import com.proto.Control.E_DIR;
import com.proto.Control.MceControl;
import com.proto.EnterGame;
import com.proto.SceneObjAppear.MseSceneObjAppear;
import com.proto.SceneObjDisappear.MseSceneObjDisappear;

public class BattleUser extends ABattleNode {

	public static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BattleUser.class.getName());
	protected MoveControl moveControl;

	private float valSpeed; // 玩家的速度属性
	private float valDegreeSpeed; // 玩家的角速度属性
	private float valSyncInterval;// 同步间隔 秒
	public BattleUser(BattleMap sceneMap, BattleModel battleModel) {
		super(sceneMap, battleModel);
		valSyncInterval = 5.0f;
		valSpeed = 4.0f;
		valDegreeSpeed = 10.0f;
		moveControl = new MoveControl(this);
	}

	@Override
	public void setUID(String uid) {
		super.setUID(uid);
		moveControl.setUID(uid);
	}

	@Override
	public void setStateReady() {
		super.setStateReady();
		moveControl.setStateStop();
	}

	@Override
	public void setStateRun() {
		super.setStateRun();
		sendEnterGame();
	}

	@Override
	public void setStateStop() {
		super.setStateStop();
		moveControl.setStateStop();
	}

	@Override
	public void update(long delta) {

	}

	public void sendAndFlush(MessageLite msg) {
		assert (null != msg);
		AccountData accountData = AccountManager.getInstance().getByUID(uid);
		if (null == accountData) {
			LOG.error("acccountData is null , uid = " + uid);
			return;
		}
		accountData.getChannel().writeAndFlush(msg);
	}

	public void updateByControl(MceControl control) {
		assert (null != control);
		System.out.println("mceControl = " + control.getIsMove());
		System.out.println(control.toString());
		if (control.getDir() == E_DIR.CENTER) {
			if (control.getIsMove()) {
				controlToMove();
			} else {
				controlToStop();
			}
		} else {
			float degreeSpeed = control.getDir() == E_DIR.LEFT ? valDegreeSpeed : -valDegreeSpeed;
			if (control.getIsMove()) {
				controlToMoveAndRotate(degreeSpeed);
			} else {
				controlToStopAndRotate(degreeSpeed);
			}
		}
	}

	private void controlToStop(){
		System.out.println("control stop");
		moveControl.setStateStop();
		sendSceneObjMove();
	}
	
	private void controlToStopAndRotate(float degreeSpeed){
		moveControl.setStateStopAndRotate(valSyncInterval,degreeSpeed, new IActionCallback() {
			
			@Override
			public void onFinish() {
				controlToStopAndRotate(degreeSpeed);
			}
		});
		sendSceneObjMove();
	}
	
	public void controlToMove(){
		moveControl.setStateMove(valSyncInterval,valSpeed , new IActionCallback() {
			
			@Override
			public void onFinish() {
				controlToMove();
			}
		});
		sendSceneObjMove();
	}
	
	public void controlToMoveAndRotate(float degreeSpeed){
		moveControl.setStateMoveAndRotate(valSyncInterval,valSpeed , degreeSpeed , new IActionCallback() {
			@Override
			public void onFinish() {
				controlToMoveAndRotate(degreeSpeed);
			}
		});
		sendSceneObjMove();
	}
	
	private void sendSceneObjMove(){
		battleModel.sendAllUser(moveControl.getCurrentMseSceneObjMove());
	}
	private void sendEnterGame() {
		EnterGame.MseEnterGame.Builder builder = EnterGame.MseEnterGame.newBuilder();
		sendAndFlush(builder.build());
	}

	@Override
	public void onAppear() {
		setInitPos();
		// send appear
		Vector2 pos = move.getPos();
		MseSceneObjAppear.Builder builder = MseSceneObjAppear.newBuilder()
		.setUid(uid)
		.setX(pos.x)
		.setY(pos.y)
		.setSpeed(valSpeed)
		.setDegree(move.getDegree())
		.setDegreeSpeed(valDegreeSpeed);
		this.battleModel.sendAllUser(builder.build());
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		SceneNodeDB sn = DBManager.getInstance().getSceneNodeDB().getSceneNode(uid);
		if (null != sn) {
			sn.setPos(move.getPos());
		} else {
			LOG.error("get sceneNOde is null:" + uid);
		}
		
		MseSceneObjDisappear.Builder builder = MseSceneObjDisappear.newBuilder();
		builder.setUid(uid);
		this.battleModel.sendAllUser(builder.build());
	}
	
	private void setInitPos() {
		SceneNodeDB sn = DBManager.getInstance().getSceneNodeDB().getSceneNode(uid);
		if (null == sn) {
			sn = DBManager.getInstance().getSceneNodeDB().addUser(uid);
			move.setPos(0.0f, 0.0f);
			sn.setPos(move.getPos());
		} else {
			move.setPos(sn.getPos());
		}
	}

}
