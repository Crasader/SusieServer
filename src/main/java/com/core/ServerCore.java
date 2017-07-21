package com.core;

import org.apache.logging.log4j.LogManager;

import com.core.handler.CustomOutboundHandler;
import com.core.handler.CustomProtobufDecoder;
import com.core.handler.CustomProtobufEncoder;
import com.core.handler.CutomInboundHandler;
import com.core.message.SignalManager;
import com.core.net.IProtoToID;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerCore {
	private int port;
	private SignalManager signal;
	private ChannelFuture f;
	EventLoopGroup bossGroup;
	EventLoopGroup workerGroup;
	private static ServerCore ince = null;
	
	public static ServerCore getInstance(){
		if (null == ince) {
			ince = new ServerCore();
		}
		return ince;
	}
	private static org.apache.logging.log4j.Logger SSLog = LogManager.getLogger(ServerCore.class.getName());
	private ServerCore(){
		signal = new SignalManager();
	}
	
	public void start(int port , IProtoToID customProtoToID) throws InterruptedException{		
		this.port = port;
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup , workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new CustomOutboundHandler());
					ch.pipeline().addLast(new CustomProtobufDecoder(customProtoToID));
					ch.pipeline().addLast(new CustomProtobufEncoder(customProtoToID));
					ch.pipeline().addLast(new CutomInboundHandler());
				}
			});
			b.option(ChannelOption.SO_BACKLOG, 128);
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			f = b.bind(this.port).sync();
			f.channel().closeFuture().sync();
		}finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public void stop(){
		try {
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public SignalManager getSignal(){
		return signal;
	}
}
