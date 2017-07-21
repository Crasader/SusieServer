package com.core.message;

public abstract class ISignalHandler {
	public String msgName = "null";
	public abstract void handler(Object target , Object data);
}
