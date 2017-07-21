package com.game.move;

import com.core.math.MathUtils;
import com.core.math.Vector2;

public class Move2D {
	private Vector2 pos;
	// 0 : left
	private float degree;
	private float speed;
	private float degreeSpeed;
	private float radius;
	private Vector2 centerPos;
	private float centerDegree;
	private float centerDegreeSpeed;

	public Move2D() {
		pos = new Vector2(0.0f, 0.0f);
		degree = 0.0f;
		speed = 0.0f;
		degreeSpeed = 0.0f;
		radius = 0;

		centerPos = new Vector2(0.0f, 0.0f);
		centerDegree = 0.0f;
		centerDegreeSpeed = 0.0f;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(float x, float y) {
		pos.set(x, y);
	}

	public void setPosX(float x) {
		pos.x = x;
	}

	public void setPosY(float y) {
		pos.y = y;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

	public float getSpeed() {
		return speed;
	}

	// 对齐角度，将角度最小化
	public void makeDegreeMin() {
		this.degree = this.degree % 360;
	}

	public float getDegreeSpeed() {
		return degreeSpeed;
	}

	public void setDegreeSpeed(float degreeSpeed) {
		this.degreeSpeed = degreeSpeed % 360;
		updateRadius();
	}

	public void setSpeed(float speed) {
		this.speed = speed;
		updateRadius();
	}

	public float getRadius() {
		return radius;
	}

	public Vector2 getCenterPos() {
		return centerPos;
	}

	public float getCenterDegree() {
		return centerDegree;
	}

	public float getCenterDegreeSpeed() {
		return centerDegreeSpeed;
	}

	public void run(long delta) {
		degree += degreeSpeed * delta / 1000;
		pos.add((float) (speed * Math.cos(degree) * delta / 1000), (float) (speed * Math.sin(degree) * delta / 1000));
	}

	public Vector2 getPosWhenMove(float deltaSecends) {
		Vector2 result = new Vector2((float) (speed * Math.cos(degree) * deltaSecends),
				(float) (speed * Math.sin(degree) * deltaSecends));
		return result.add(pos);
	}

	public void setPos(Vector2 pos2) {
		setPos(pos2.x, pos2.y);
	}

	public void setCenterDegreeAndUpdatePos(float degree) {
		this.centerDegree = degree;
		pos.x = centerPos.x + radius * (float) Math.cos(centerDegree);
		pos.y = centerPos.y + radius * (float) Math.sin(centerDegree);
	}

	private void updateRadius() {
		if (0 == degreeSpeed) {
			radius = -1.0f; // <0 表示无穷大
			centerPos.set(pos);
			centerDegree = 0.0f;
			centerDegreeSpeed = 0.0f;
			return;
		}

		radius = (speed * 180 / Math.abs(degreeSpeed)) / MathUtils.PI;
		if (degreeSpeed > 0) {
			centerDegree = degree - 90;
			centerDegreeSpeed = degreeSpeed;
		} else {
			centerDegree = 90 - degree;
			centerDegreeSpeed = degreeSpeed;
		}
		centerDegree = centerDegree % 360;
		centerDegreeSpeed = centerDegreeSpeed % 360;

		centerPos.x = pos.x - radius * (float) Math.cos(centerDegree);
		centerPos.y = pos.y - radius * (float) Math.sin(centerDegree);
	}
}
