package com.core.net;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

public interface IProtoToID {
	// 可以把msg转为对应的ID
	int getIDByMsg(MessageLite msg);
	
	GeneratedMessageV3 getMesByID(int id); 
}
