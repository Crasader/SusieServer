package com.game.action;

import com.core.math.Vector2;

public class MoveToAction extends BasicAction
{
	private Vector2 m_target;
	private Vector2 m_start;
	public MoveToAction(Vector2 target , float interval){
		this.interval = interval;
		m_target = target;
	}
	@Override
	public void Start() {
		super.Start ();
		m_start = sceneNode.getMove().getPos();
	}
	
	public void BaseUpate (){
		sceneNode.getMove().setPos(Vector2.Leap(m_start, m_target, curTime / interval));
	}
}