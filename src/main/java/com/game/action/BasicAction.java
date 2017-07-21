package com.game.action;

import com.game.scene.node.SceneNode;

public abstract class BasicAction
	{
		protected Boolean isDelete;

		protected float interval;

		protected float curTime;

		protected IActionCallback delegateMessage;

		protected SceneNode sceneNode;
	
		public BasicAction ()
		{
			isDelete = false;	
		}
		
		public void setSceneNode(SceneNode node){
			this.sceneNode = node;
		}
		
		public SceneNode getSceneNode(){
			return this.sceneNode;
		}
		
		public float getInterval(){
			return this.interval;
		}
		
		public void SetFinishDelegate (IActionCallback delegateMessage)
		{
			this.delegateMessage = delegateMessage;
		}
		
		public boolean isDelete(){
			return isDelete;
		}
		
		public void setIsDelete(boolean isDelete){
			this.isDelete = isDelete;
		}

		public void Start ()
		{
			isDelete = false;
			curTime = 0.0f;
		}

		public void Update (float deltaTime)
		{
			if (isDelete)
				return;
			if (curTime >= interval) {
				curTime = interval;
				isDelete = true;
			}

			BaseUpate ();

			if (!isDelete) {
				curTime += deltaTime;
			} else {
				DoFinish ();
				DoFinishDelegate ();
			}
		}

		public void DoFinishDelegate ()
		{
			if (null != delegateMessage) {
				delegateMessage.onFinish();
				delegateMessage = null;
			}
		}

		public abstract void BaseUpate ();

		public void DoFinish ()
		{

		}
	}

