package com.core.account;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class AccountManager {
	private static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(AccountManager.class.getName());
	private static AccountManager ince = null;
	private Map<String, AccountData> channelIDToDataMap;
	private Map<String, AccountData> uidToDataMap;
	
	public static AccountManager getInstance(){
		if (null == ince) {
			ince = new AccountManager();
		}
		return ince;
	}
	
	private AccountManager(){
		channelIDToDataMap = new HashMap<>();
		uidToDataMap = new HashMap<>();
	}
	
	public AccountData getByChannelShortID(String channelShortID){
		return channelIDToDataMap.get(channelShortID);
	}
	
	public String getUIDByCtx(ChannelHandlerContext ctx){
		if (null == ctx){
			LOG.error("ctx is null");
			return null;
		}
		Channel channel = ctx.channel();
		AccountData data = getByChannelShortID(channel.id().asShortText());
		if(null == data){
			LOG.error("can't find account :" + channel.id().asShortText());
			return null;
		}
		return data.getUid();
	}
	
	public AccountData getByUID(String uid){
		return uidToDataMap.get(uid);
	}
		
	public boolean isHasDataByChannel(String channelShortID){
		return channelIDToDataMap.containsKey(channelShortID);
	}
	
	public boolean isHasDataByUID(String uid){
		return uidToDataMap.containsKey(uid);
	}
	
	public AccountData addCtx(ChannelHandlerContext ctx , String uid){
		Channel channel = ctx.channel();
		if (isHasDataByChannel(channel.id().asShortText())) {
			LOG.error("add the same channel , channleId = " + channel.id().asShortText());
			return null;
		}
		AccountData data = new AccountData(channel , uid);
		channelIDToDataMap.put(channel.id().asShortText(), data);
		uidToDataMap.put(uid, data);
		return data;
	}
	
	public void closeCtx(ChannelHandlerContext ctx){
		Channel channel = ctx.channel();
		AccountData data = getByChannelShortID(channel.id().asShortText());
		if (null != data) {
			data.close();
			channelIDToDataMap.remove(channel.id().asShortText());
			uidToDataMap.remove(data.getUid());
		}else{
			ctx.close();
		}
		
		LOG.info("close channel = " + channel.id().asShortText());
		printInfo();
	}
	
	public void printInfo(){
		LOG.info("========= printInfo ===============");
		LOG.info("channelIDToDataMap.size = " + channelIDToDataMap.values().size());
		LOG.info("uidToDataMap.size = " + uidToDataMap.values().size());
	}
	
}
