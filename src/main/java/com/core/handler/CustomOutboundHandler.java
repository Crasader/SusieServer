package com.core.handler;

import java.net.SocketAddress;

import org.apache.logging.log4j.LogManager;

import com.core.account.AccountManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class CustomOutboundHandler extends ChannelOutboundHandlerAdapter{
	private static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(CustomOutboundHandler.class.getName());

	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
		// TODO Auto-generated method stub
		super.close(ctx, promise);
		
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		// TODO Auto-generated method stub
		super.write(ctx, msg, promise);
	}
	
	@Override
	public void flush(ChannelHandlerContext ctx) throws Exception {
       super.flush(ctx);
    }

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}
	
}
