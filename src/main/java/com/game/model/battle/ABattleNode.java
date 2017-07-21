package com.game.model.battle;

import org.apache.logging.log4j.LogManager;

import com.game.model.BattleModel;
import com.game.scene.node.SceneNode;

public abstract class ABattleNode extends SceneNode {
	protected static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ABattleNode.class.getName());

	public enum E_STATE {
		READY, RUN, STOP,
	}

	public String uid;
	protected BattleMap sceneMap;
	protected BattleModel battleModel;
	protected E_STATE state;

	public ABattleNode(BattleMap sceneMap, BattleModel battleModel) {
		this.sceneMap = sceneMap;
		this.battleModel = battleModel;
		state = E_STATE.READY;
	}

	public void setUID(String uid) {
		this.uid = uid;
	}

	public void setStateReady() {
		state = E_STATE.READY;
	}

	public void setStateRun() {
		state = E_STATE.RUN;
	}

	public void setStateStop() {
		state = E_STATE.STOP;
	}

	public abstract void update(long delta);

	public abstract void onAppear();

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
