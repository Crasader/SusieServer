package com.core.handler;

import com.google.protobuf.MessageLite;

public class ProtoData {
	public int msgType;
	public MessageLite msgData;
	
	public ProtoData(int msgType , MessageLite msgData){
		this.msgType = msgType;
		this.msgData = msgData;
	}
}
