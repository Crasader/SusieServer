package com.game.db;

import java.util.UUID;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class UserDBCollect {
	public class UseDB{
		private Document dbObj;
		public UseDB(){
			
		}
		
		public UseDB setDBObj(Document dbObj){
			this.dbObj = dbObj;
			return this;
		}
		
		public String getUID(){
			System.out.println(dbObj);
			return dbObj.getString("uid");
		}
	}
	
	private MongoCollection<Document> dbCollection = null;
	private UseDB tempUserObj;
	public UserDBCollect(DBManager dbManager){
		this.dbCollection = dbManager.getCollection("User");
		assert null!= dbCollection:"dbCollection is null";
		this.tempUserObj = new UseDB();
	}
	
	public UseDB getUserDBObj(String name , String pass){
		Document result = dbCollection.find(Filters.eq("user" , name)).first();
		if(null == result)return null;
		return tempUserObj.setDBObj(result);
	}
	
	public UseDB addUser(String name , String pass){
		Document result = new Document().append("user", name);
		result.append("pass", pass);
		result.append("uid" , UUID.randomUUID().toString());
		dbCollection.insertOne(result);
		return tempUserObj.setDBObj(result);
	}
}
