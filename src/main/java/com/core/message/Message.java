package com.core.message;

public class Message {
	public String msgName;
	public Object target;
	public Object data;
	
	public Message(String msgName , Object target , Object data){
		this.msgName = msgName;
		this.target = target;
		this.data = data;
	}
}
