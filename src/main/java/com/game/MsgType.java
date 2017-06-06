package com.game;

public interface MsgType {
	// client
	public static int MceAuth      = 1;
	public static int MceControl   = 2;
	public static int MceEnterGame = 3;
	public static int MceHeartbeat = 4;
	
	public static int MseAuth      = 1001;
	public static int MseEnterGame = 1002;
	public static int MseHeartbeat = 1003;
	public static int MseMove      = 1004;
	public static int MseUserInfo  = 1005;
}
