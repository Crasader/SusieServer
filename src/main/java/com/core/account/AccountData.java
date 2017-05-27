package com.core.account;

import com.core.ServerCore;
import com.core.message.Message;
import com.core.message.MessageDef;

import io.netty.channel.ChannelHandlerContext;

public class AccountData {
	private ChannelHandlerContext ctx;
	private String uid;
	
	public AccountData(ChannelHandlerContext ctx , String uid){
		this.ctx = ctx;
		this.uid = uid;
	}
	
	public boolean isHasUid(){
		return !uid.isEmpty();
	}
	
	public ChannelHandlerContext getCtx(){
		return ctx;
	}
	
	public String getUid(){
		return uid;
	}

	public void close() {
		Message msg = new Message(MessageDef.MSG_ACCOUNT_CLOSE, this , uid);
		ServerCore.getInstance().getSignal().addDelayMessage(msg);
		ctx.close();
	}
}
