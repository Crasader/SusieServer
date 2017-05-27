package com.proto;

import com.core.net.IProtoToID;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

public class GameProtoToID implements IProtoToID {

	@Override
	public int getIDByMsg(MessageLite msg) {
		int messageType = -1;

		if (msg instanceof Auth.MseAuth) {
			messageType = 512;
		}else if(msg instanceof MseUserInfoOuterClass.MseUserInfo){
			messageType = 516;
		}else if(msg instanceof TransScene.MseTransScene){
			messageType = 519;
		}else if(msg instanceof MseShipInfoOuterClass.MseShipInfo){
			messageType = 523;
		}
		return messageType;
	}

	@Override
	public  GeneratedMessageV3 getMesByID(int messageType) {
		if (messageType == 1024 ) {
			return Heartbeat.MceHeartbeat.getDefaultInstance();
		}else if(messageType == 1025){
			return Auth.MceAuth.getDefaultInstance();
		}else if(messageType == 1029){
			return EnterGame.MceEnterGame.getDefaultInstance();
		}else if(messageType == 1032){
			return MceShipInfoOuterClass.MceShipInfo.getDefaultInstance();
		}
		return null;
	}

}
