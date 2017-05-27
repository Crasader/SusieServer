package test;

import com.core.ServerCore;
import com.core.account.AccountManager;
import com.core.handler.ProtoData;
import com.core.message.Message;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Sharable
public class ClientInboundHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("read = " + msg.getClass().getName());
		if (msg instanceof ProtoData) {
			ProtoData pData = (ProtoData) msg;
			String msgName = "proto_" + pData.msgType; 
			TestClient.getInstance().getSignal().addDelayMessage(new Message(msgName , ctx, pData.msgData));
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inactive = " + ctx.name());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		
	}	
}