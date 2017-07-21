package com.game.action;

public class RotationToAction extends BasicAction
{
	private float m_startAngle;
	private float m_targetAngle;
	
	public RotationToAction(float targetAngle ,  float interval){
		m_targetAngle = targetAngle;
		this.interval = interval;
	}
	
	@Override
	public void Start() {
			super.Start ();
			m_startAngle = sceneNode.getMove().getDegree();
		}
	
	public void BaseUpate (){
			float curAngle = m_startAngle + curTime / interval *( m_targetAngle - m_startAngle);
			sceneNode.getMove().setDegree(curAngle);
		}
}
