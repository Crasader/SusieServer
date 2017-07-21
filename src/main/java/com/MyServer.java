package com;

import java.net.UnknownHostException;
import java.util.Date;

import com.core.ServerCore;
import com.game.GameConfig;
import com.game.GameProtoToID;
import com.game.action.ActionManager;
import com.game.db.DBManager;
import com.game.model.ModelManager;

public class MyServer {
	private static boolean isRun = false;
	
	public static void startMainThread(ServerCore sc){
		isRun = true;
		new Thread(new Runnable() {	
			@Override
			public void run() {
				Date date =new Date();
				long curTime;
				long deltaTime = GameConfig.intevalFps;
				while(isRun){
					curTime = date.getTime();
					ActionManager.GetInstance().Update(deltaTime);
					ModelManager.getInstance().getScene().update(deltaTime);
					sc.getSignal().logic();
					// calculate time
					long sleepTime = date.getTime() - curTime;
					deltaTime = GameConfig.intevalFps > sleepTime?GameConfig.intevalFps:sleepTime;
					sleepTime = GameConfig.intevalFps - sleepTime;
					try {
						if(sleepTime > 0 )
						{
							Thread.sleep(sleepTime);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
						stopMainThread();
					}
				}
			}
		}).start();
	}
	
	public static void stopMainThread(){
		isRun = false;
		DBManager.getInstance().stop();
	}
	public static void main(String[] args) throws UnknownHostException{
		ServerCore sc = ServerCore.getInstance();
		// 数据库启动
		DBManager.getInstance().start();
		// 模块启动
		ModelManager.getInstance().init();
		
		startMainThread(sc);
		try {
			sc.start(1443, new GameProtoToID());
			stopMainThread();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			stopMainThread();
		}
	}
}
