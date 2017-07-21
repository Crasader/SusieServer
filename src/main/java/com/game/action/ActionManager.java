package com.game.action;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.game.model.battle.ABattleNode;
import com.game.scene.node.SceneNode;

// can stop , resume , quicker deng
public class ActionManager {
	private static ActionManager Ince = null;

	private List<BasicAction> actionList;

	private List<BasicAction> addActionList;

	public static ActionManager GetInstance() {
		if (null == Ince) {
			Ince = new ActionManager();
		}
		return Ince;
	}

	private ActionManager() {
		actionList = new LinkedList<>();
		addActionList = new LinkedList<>();
	}

	public void RunAction(SceneNode sceneNode, BasicAction action, IActionCallback delegateActionFinish) {
		action.setSceneNode(sceneNode);
		action.SetFinishDelegate(delegateActionFinish);
		if (action.getInterval() <= 0.0f) {
			action.DoFinishDelegate();
			return;
		}

		addActionList.add(action);
		action.Start();

	}

	public void Update(float deltaTime) {
		for (BasicAction action : actionList) {
			action.Update(deltaTime);
		}

		for (BasicAction action : addActionList) {
			action.Update(deltaTime);
			actionList.add(action);
		}
		addActionList.clear();

		DelActionReadyForDel();
	}

	public void RemoveSceneNode(SceneNode sceneNode) {
		for (BasicAction action : actionList) {
			if (action.getSceneNode() == sceneNode) {
				action.setIsDelete(true);
			}
		}
		DelActionReadyForDel();
	}

	public String ToString() {
		return "action length = " + actionList.size();
	}

	private void DelActionReadyForDel() {
		Iterator<BasicAction> it = actionList.iterator();
		while (it.hasNext()) {
			BasicAction action = it.next();
			if (action.isDelete()) {
				it.remove();
			}
		}
	}
}
