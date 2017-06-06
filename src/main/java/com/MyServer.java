package com;

import java.net.UnknownHostException;

import com.core.ServerCore;
import com.game.GameProtoToID;
import com.game.db.DBManager;
import com.game.model.ModelManager;

public class MyServer {
	private static boolean isRun = false;
	
	public static void startMainThread(ServerCore sc){
		isRun = true;
		new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(isRun){
					sc.getSignal().logic();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stopMainThread();
		}
	}
}
