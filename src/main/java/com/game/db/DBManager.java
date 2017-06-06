package com.game.db;

import java.net.UnknownHostException;

import org.bson.Document;

import com.game.GameConfig;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBManager {
	private static DBManager ince = null;
	private MongoClient mc;
	private MongoDatabase db;
	// 数据库
	private UserDBCollect userDB;
	
	public static DBManager getInstance(){
		if(null == ince) {
			ince = new DBManager();
		}
		return ince;
	}
	
	public void start() throws UnknownHostException{
		mc = new MongoClient(GameConfig.DBIP , GameConfig.DBPort);
		db = mc.getDatabase(GameConfig.DBName);
		
		userDB = new UserDBCollect(this);
	}
	
	public void stop(){
		if(null != mc){			
			mc.close();
			mc = null;
			db = null;
		}
		
		userDB = null;
	}
	
	public MongoDatabase getDB(){
		return db;
	}
	
	public MongoCollection<Document> getCollection(String name){
		if(null == db) return null;
		return db.getCollection(name);
	}
	
	// 数据库
	public UserDBCollect getUserDB(){
		return userDB;
	}
	
	
}
