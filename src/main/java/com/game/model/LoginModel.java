package com.game.model;

import com.core.ServerCore;
import com.core.account.AccountManager;
import com.core.message.ISignalHandler;
import com.proto.Auth;
import com.proto.MseShipInfoOuterClass;
import com.proto.MseUserInfoOuterClass;
import com.proto.TransScene;

import io.netty.channel.ChannelHandlerContext;

public class LoginModel {
	public LoginModel(){
		registAuth();
		registEnterGame();
		registShipInfo();
	}
	
	public void registAuth(){
		ServerCore.getInstance().getSignal().register("proto_1025", new ISignalHandler() {
			
			@Override
			public void handler(Object target, Object data) {
				// TODO Auto-generated method stub
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				Auth.MceAuth aa = (Auth.MceAuth)data;
				System.out.println("id = "+aa.getId());
				System.out.println("pass = "+aa.getPass());
				String uid = "123213213213";
				AccountManager.getInstance().addCtx(ctx , uid);
				
				Auth.MseAuth.Builder mseAuth =  Auth.MseAuth.newBuilder();
				mseAuth.setUid("12312332123213");
				mseAuth.setName("hello world");
				mseAuth.setSucc(true);
				ctx.writeAndFlush(mseAuth.build());
			}
		});
	}
	
	public void registEnterGame(){
		ServerCore.getInstance().getSignal().register("proto_1029", new ISignalHandler() {
			@Override
			public void handler(Object target, Object data) {
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				sendUserInfo(ctx);
				sendTransScene(ctx);
				ctx.flush();
			}
		});
	}
	
	public void registShipInfo(){
		ServerCore.getInstance().getSignal().register("proto_1032", new ISignalHandler() {
			@Override
			public void handler(Object target, Object data) {
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				MseShipInfoOuterClass.MseShipInfo.Builder builder = MseShipInfoOuterClass.MseShipInfo.newBuilder();
				ctx.writeAndFlush(builder.build());
			}
		});
	}
	
	private void sendUserInfo(ChannelHandlerContext ctx){
		MseUserInfoOuterClass.MseUserInfo.Builder builder = MseUserInfoOuterClass.MseUserInfo.newBuilder();
		builder.setHeadStr("[1,3,1,4,5,1,0,1,1]")
		.setTid(100)
		.setUserName("trtrtr")
		.setLevel(53)
		.setSuit(10000)
		.setIsLevelUp(false)
		.setOid(429502281111l)
		.setExpMax(19223123)
		.setExp(1221)
		.setCamp(4);
		ctx.write(builder.build());
		
	}
	
	private void sendTransScene(ChannelHandlerContext ctx){
		TransScene.MseTransScene.Builder builder = TransScene.MseTransScene.newBuilder()
				.setSceneId(255001)
				.setX(-2016)
				.setY(8176)
				.setD(360);
		ctx.write(builder.build());
	}
}
