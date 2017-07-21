package com.core.message;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public class SignalManager {
	public static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(SignalManager.class.getName());
	private MessageQueue msgQueue;
	private Map<String, HashSet<ISignalHandler>> handlerMap;

	public SignalManager() {
		msgQueue = new MessageQueue();
		handlerMap = new HashMap<>();
	}

	public void addDelayMessage(Message msg) {
		msgQueue.addMessage(msg);
	}

	public void sendMessage(Message msg) {
		HashSet<ISignalHandler> set = handlerMap.get(msg.msgName);
		if (null == set)
			return;
		for (ISignalHandler iSignalHandler : set) {
			iSignalHandler.handler(msg.target, msg.data);
		}
	}

	public void register(String msgName, ISignalHandler handler) {
		if (null == handler) {
			LOG.error("SignalManager.register error , handler is null");
			return;
		}
		handler.msgName = msgName;
		HashSet<ISignalHandler> set = handlerMap.get(msgName);
		if (null == set) {
			set = new HashSet<>();
			handlerMap.put(msgName, set);
		}
		set.add(handler);
	}

	public void unregister(ISignalHandler handler) {
		if (null == handler) {
			LOG.error("SignalManager.unregister error , handler is null");
			return;
		}
		HashSet<ISignalHandler> set = handlerMap.get(handler.msgName);
		if(null == set){
			return;
		}
		set.remove(handler);
		if(set.isEmpty()){
			handlerMap.remove(handler.msgName);
		}
	}

	public void logic() {
		Message curMsg = null;
		while ((curMsg = msgQueue.popMessage()) != null) {
			sendMessage(curMsg);
		}
	}
}
