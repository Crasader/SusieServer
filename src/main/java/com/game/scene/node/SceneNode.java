package com.game.scene.node;

import com.game.action.ActionManager;
import com.game.action.BasicAction;
import com.game.action.IActionCallback;
import com.game.move.Move2D;

public class SceneNode {
	protected ActionManager actionManager;
	protected Move2D move;
	public SceneNode(){
		move = new Move2D();
		actionManager = ActionManager.GetInstance();
	}
	
	public Move2D getMove(){
		return move;
	}
	
	// when being cleared from scene
	public void onDestroy(){
		actionManager.RemoveSceneNode(this);
	}
	
	public void runAction(BasicAction action , IActionCallback delegateActionFinish){
		actionManager.RunAction(this, action, delegateActionFinish);
	}
	
}
