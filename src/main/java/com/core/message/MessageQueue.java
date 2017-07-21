package com.core.message;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageQueue {
	private Queue<Message> msgQueue;
	public MessageQueue(){
		msgQueue = new ConcurrentLinkedQueue<>();
	}
	
	public void addMessage(Message message){
		msgQueue.offer(message);
	}
	
	public Message popMessage(){
		return msgQueue.poll();
	}
}
