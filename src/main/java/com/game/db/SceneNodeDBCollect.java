package com.game.db;

import org.apache.logging.log4j.LogManager;
import org.bson.Document;

import com.core.math.Vector2;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class SceneNodeDBCollect{
	private static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(SceneNodeDBCollect.class.getName());
	public class SceneNodeDB{
		private MongoCollection<Document> myCollection;
		private Document dbObj;
		public SceneNodeDB(MongoCollection<Document> myCollection){
			this.myCollection = myCollection;
		}
		
		public SceneNodeDB setDBObj(Document dbObj){
			this.dbObj = dbObj;
			return this;
		}
		
		public Vector2 getPos(){
			double x = dbObj.getDouble("x");
			double y = dbObj.getDouble("y");
			return new Vector2((float)x,(float)y);
		}
		
		public void setPos(Vector2 pos){
			LOG.debug("setPos = " + pos);
			myCollection.updateOne(dbObj,new Document("$set" , new Document("x",pos.x).append("y", pos.y)));
			dbObj.put("x", pos.x);
			dbObj.put("y", pos.y);
		}
	}
	
	private MongoCollection<Document> dbCollection = null;
	private SceneNodeDB tempUserObj;
	public SceneNodeDBCollect(DBManager dbManager){
		this.dbCollection = dbManager.getCollection("SceneNode");
		assert null!= dbCollection:"dbCollection is null";
		this.tempUserObj = new SceneNodeDB(this.dbCollection);
	}
	
	public SceneNodeDB getSceneNode(String uid){
		Document result = dbCollection.find(Filters.eq("uid" , uid)).first();
		if(null == result)return null;
		return tempUserObj.setDBObj(result);
	}
	
	public SceneNodeDB addUser(String uid){
		Document result = new Document().append("uid", uid);
		result.append("x", 0.0);
		result.append("y", 0.0);
		dbCollection.insertOne(result);
		return tempUserObj.setDBObj(result);
	}
}