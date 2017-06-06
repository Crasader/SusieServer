package com.core.account;

import java.util.HashMap;
import java.util.Map;

import com.core.util.SSLog;

import io.netty.channel.ChannelHandlerContext;

public class AccountManager {
	private static AccountManager ince = null;
	private Map<String, AccountData> accountDataMap;
	
	public static AccountManager getInstance(){
		if (null == ince) {
			ince = new AccountManager();
		}
		return ince;
	}
	
	private AccountManager(){
		accountDataMap = new HashMap<>();
	}
	
	public AccountData getByCtxName(String ctxName){
		return accountDataMap.get(ctxName);
	}
	
	public String getUIDByCtx(ChannelHandlerContext ctx){
		if (null == ctx){
			return "null ctx";
		}
		AccountData data = getByCtxName(ctx.name());
		if(null == data){
			return "can't find account";
		}
		return data.getUid();
	}
	
	public AccountData addCtx(ChannelHandlerContext ctx , String uid){
		if (isHasData(ctx.name())) {
			SSLog.Error("add the same ctx , ctx name = " + ctx.name());
			return null;
		}
		AccountData data = new AccountData(ctx , uid);
		accountDataMap.put(ctx.name(), data);
		return data;
	}
	
	public boolean isHasData(String ctxName){
		return accountDataMap.containsKey(ctxName);
	}
	
	public void closeCtx(ChannelHandlerContext ctx){
		AccountData data = getByCtxName(ctx.name());
		System.out.println("closeCtx:"+data.getUid());
		if (null != data) {
			data.close();
			accountDataMap.remove(ctx.name());
		}else{
			ctx.close();
		}
	}
	
}
