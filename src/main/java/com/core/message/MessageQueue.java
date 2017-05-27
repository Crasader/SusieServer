package com.core.message;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
	private Queue<Message> msgQueue;
	public MessageQueue(){
		msgQueue = new LinkedList<>();
	}
	
	public void addMessage(Message message){
		msgQueue.offer(message);
	}
	
	public Message popMessage(){
		return msgQueue.poll();
	}
}
