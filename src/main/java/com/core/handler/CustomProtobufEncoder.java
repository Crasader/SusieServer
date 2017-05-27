package com.core.handler;
import com.core.net.IProtoToID;
import com.core.util.SSLog;
import com.google.protobuf.MessageLite;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 参考ProtobufVarint32LengthFieldPrepender 和 ProtobufEncoder
 */
@Sharable
public class CustomProtobufEncoder extends MessageToByteEncoder<MessageLite> {
    private IProtoToID customProtoToID;
	public CustomProtobufEncoder(IProtoToID customProtoToID) {
		this.customProtoToID = customProtoToID;
	}
	
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLite msg, ByteBuf out) throws Exception {
        int messageType = customProtoToID.getIDByMsg(msg);
        if (messageType < 1) {
			SSLog.Info("getIDByMsg < 1 , msg = " + msg.toString());
			return;
		}
        System.out.println("=====encode==========messageType = " + messageType);
        byte[] body = msg.toByteArray();
        // head
        out.writeInt(body.length+6); //4
        out.writeShort(messageType); //4
        out.writeInt(12); 		   //1
        out.writeBytes(body);	
        return;
    }
}