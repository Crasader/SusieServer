package com.game;

import com.core.net.IProtoToID;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;
import com.proto.Auth;
import com.proto.Control;
import com.proto.EnterGame;
import com.proto.Heartbeat;
import com.proto.Move;
////client
//MceAuth = 1
//MceControl = 2
//MceEnterGame = 3
//MceHeartbeat = 4
//
//MseAuth = 1001
//MseEnterGame = 1002
//MseHeartbeat = 1003
//MseMove = 1004
//MseUserInfo = 1005
import com.proto.UserInfo;

public class GameProtoToID implements IProtoToID {

	@Override
	public int getIDByMsg(MessageLite msg) {
		int messageType = -1;

		if (msg instanceof Auth.MseAuth) {
			messageType = MsgType.MseAuth;
		}else if(msg instanceof EnterGame.MseEnterGame){
			messageType = MsgType.MseEnterGame;
		}else if(msg instanceof Heartbeat.MseHeartbeat){
			messageType = MsgType.MseHeartbeat;
		}else if(msg instanceof Move.MseMove){
			messageType = MsgType.MseMove;
		}else if(msg instanceof UserInfo.MseUserInfo){
			messageType = MsgType.MseUserInfo;
		}
		return messageType;
	}

	@Override
	public  GeneratedMessageV3 getMesByID(int messageType) {
		if (messageType == MsgType.MceAuth ) {
			return Auth.MceAuth.getDefaultInstance();	
		}else if(messageType == MsgType.MceControl){
			return Control.MceControl.getDefaultInstance();
		}else if(messageType == MsgType.MceEnterGame){
			return EnterGame.MceEnterGame.getDefaultInstance();
		}else if(messageType == MsgType.MceHeartbeat){
			return Heartbeat.MceHeartbeat.getDefaultInstance();
		}
		return null;
	}

}

