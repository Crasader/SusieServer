package com.game.action;

public class MoveRoundAction extends BasicAction {
	private float m_startAngle;
	private float m_targetAngle;

	public MoveRoundAction(float targetAngle ,  float interval){
		m_targetAngle = targetAngle;
		this.interval = interval;
	}

	@Override
	public void Start() {
		super.Start();
		m_startAngle = sceneNode.getMove().getCenterDegree();
	}

	public void BaseUpate() {
		float curAngle = m_startAngle + curTime / interval * (m_targetAngle - m_startAngle);
		sceneNode.getMove().setCenterDegreeAndUpdatePos(curAngle);
	}
}
