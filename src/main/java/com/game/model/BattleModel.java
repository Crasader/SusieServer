package com.game.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.core.ServerCore;
import com.core.account.AccountManager;
import com.core.message.ISignalHandler;
import com.core.message.MessageDef;
import com.game.MsgType;
import com.game.model.battle.ABattleNode;
import com.game.model.battle.BattleMap;
import com.game.model.battle.BattleUser;
import com.google.protobuf.MessageLite;
import com.proto.Control;
import com.proto.SceneObjAppear;

import io.netty.channel.ChannelHandlerContext;

public class BattleModel {
	public static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BattleModel.class.getName());
	private Map<String , ABattleNode> mapNode;
	
	// 场景数据
	private BattleMap sceneMap;
	
	public BattleModel(){
		sceneMap = new BattleMap();
		mapNode = new HashMap<>();
		registCloseCtx();
		registMseControl();
	}


	public void update(long deltaTime){

	}
	
	public void addUser(String uid){
		mapNode.remove(uid);
		
		BattleUser user = new BattleUser(sceneMap , this);
		user.setUID(uid);
		user.setStateRun();
		mapNode.put(uid, user);
		user.onAppear();
	}
	
	public void removeNode(String uid){
		ABattleNode node = mapNode.get(uid);
		if(null == node) {
			LOG.error("removeNode error:"+uid);
			return;
		}else{
			node.onDestroy();
		}
		mapNode.remove(uid);
	}
		
	public void sendAllUser(MessageLite msg){
		for (ABattleNode node : mapNode.values()) {  	  
		    if(node instanceof BattleUser){
		    	((BattleUser) node).sendAndFlush(msg);
		    }
		} 
	}
	
	private BattleUser getUser(String uid){
		ABattleNode node = mapNode.get(uid);
		if(null == node){
			LOG.error("can't find node:"+uid);
			return null;
		}
		
		if (node instanceof BattleUser == false){
			LOG.error("node is not SceneUser:" + uid);
			return null;
		}
		
		return (BattleUser)node;
	}
	
	private void registMseControl() {
		ServerCore.getInstance().getSignal().register("proto_" + MsgType.MceControl , new ISignalHandler() {
			
			@Override
			public void handler(Object target, Object data) {
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				String uid = AccountManager.getInstance().getUIDByCtx(ctx);
				if(null == uid) return;
			    Control.MceControl control = (Control.MceControl)data;
			    BattleUser user = getUser(uid);
			    if(null == user) return;
			    user.updateByControl(control);
			}
		});
	}
	
	// regist
	private void registCloseCtx(){
		ServerCore.getInstance().getSignal().register(MessageDef.MSG_ACCOUNT_CLOSE , new ISignalHandler() {
			
			@Override
			public void handler(Object target, Object data) {
				String uid = (String) data;
				removeNode(uid);
			}
		});
	}
	
}
