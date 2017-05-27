package com.core.message;

import java.util.HashMap;
import java.util.Map;

public class SignalManager {
	private MessageQueue msgQueue;
	private Map<String , ISignalHandler> handlerMap;
	public SignalManager(){
		msgQueue = new MessageQueue();
		handlerMap = new HashMap<>();
	}
	
	
	public void addDelayMessage(Message msg){
		msgQueue.addMessage(msg);
	}
	
	public void sendMessage(Message msg){
		ISignalHandler handler = handlerMap.get(msg.msgName);
		if(null != handler){
			handler.handler(msg.target, msg.data);
		}
	}
	
	public void register(String msgName , ISignalHandler handler){
		handlerMap.put(msgName, handler);
	}
	
	public void unregister(String msgName){
		handlerMap.remove(msgName);
	}
	
	public void logic(){
		Message curMsg = null;
		while((curMsg = msgQueue.popMessage()) != null){
			sendMessage(curMsg);
		}
	}
}
