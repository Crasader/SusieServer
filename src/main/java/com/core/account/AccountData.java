package com.core.account;

import com.core.ServerCore;
import com.core.message.Message;
import com.core.message.MessageDef;

import io.netty.channel.Channel;

public class AccountData {
	private Channel channel;
	private String uid;
	
	public AccountData(Channel channel , String uid){
		this.channel = channel;
		this.uid = uid;
	}
	
	public boolean isHasUid(){
		return !uid.isEmpty();
	}
	
	public Channel getChannel(){
		return channel;
	}
	
	public String getUid(){
		return uid;
	}

	public void close() {
		Message msg = new Message(MessageDef.MSG_ACCOUNT_CLOSE, this, uid);
		ServerCore.getInstance().getSignal().addDelayMessage(msg);
		channel.close();
	}
}
