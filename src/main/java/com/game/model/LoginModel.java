package com.game.model;

import com.core.ServerCore;
import com.core.account.AccountManager;
import com.core.message.ISignalHandler;
import com.game.MsgType;
import com.game.db.DBManager;
import com.game.db.UserDBCollect;
import com.proto.Auth;
import com.proto.UserInfo;

import io.netty.channel.ChannelHandlerContext;

public class LoginModel {
	public LoginModel(){
		registAuth();
		registEnterGame();
	}
	
	public void registAuth(){
		ServerCore.getInstance().getSignal().register("proto_"+MsgType.MceAuth, new ISignalHandler() {
			
			@Override
			public void handler(Object target, Object data) {
				// TODO Auto-generated method stub
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				Auth.MceAuth aa = (Auth.MceAuth)data;
				System.out.println("id = "+aa.getId());
				System.out.println("pass = "+aa.getPass());
				UserDBCollect userDB = DBManager.getInstance().getUserDB();
				UserDBCollect.UserObj userObj = userDB.getUserDBObj(aa.getId(), aa.getPass());
				if(null == userObj){
					userObj = userDB.addUser(aa.getId(), aa.getPass());
				}
				
				String uid = userObj.getUID();
				System.out.println("uid = "+uid);
				AccountManager.getInstance().addCtx(ctx , uid);
				
				Auth.MseAuth.Builder mseAuth =  Auth.MseAuth.newBuilder();
				mseAuth.setUid(uid);
				mseAuth.setSucc(true);
				ctx.writeAndFlush(mseAuth.build());
			}
		});
	}
	
	public void registEnterGame(){
		ServerCore.getInstance().getSignal().register("proto_"+MsgType.MceEnterGame, new ISignalHandler() {
			@Override
			public void handler(Object target, Object data) {
				ChannelHandlerContext ctx = (ChannelHandlerContext)target;
				String uid = AccountManager.getInstance().getUIDByCtx(ctx);
				System.out.println("uid =" + uid);
				sendUserInfo(ctx , uid);
				ctx.flush();
			}
		});
	}
	
	private void sendUserInfo(ChannelHandlerContext ctx , String uid){
		UserInfo.MseUserInfo.Builder builder = UserInfo.MseUserInfo.newBuilder();
		builder.setUid(uid);
		builder.setUserName("test");
		ctx.write(builder.build());
	}
	
}
