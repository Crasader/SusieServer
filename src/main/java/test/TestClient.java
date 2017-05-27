package test;

import com.core.handler.CustomProtobufDecoder;
import com.core.handler.CustomProtobufEncoder;
import com.core.message.SignalManager;
import com.core.net.IProtoToID;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestClient{
	private static TestClient ince = null;
	
	private boolean isRun = false;
	private SignalManager signal;
	
	public SignalManager getSignal(){
		return signal;
	}
	
	public static TestClient getInstance(){
		if (null == ince) {
			ince = new TestClient();
		}
		return ince;
	}
	
	private TestClient(){
		signal = new SignalManager();
	}
	
	public void start(IProtoToID customProtoToID) throws InterruptedException{
		isRun = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(isRun){
					signal.logic();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new CustomProtobufDecoder(customProtoToID));
					ch.pipeline().addLast(new CustomProtobufEncoder(customProtoToID));
					ch.pipeline().addLast(new ClientInboundHandler());
				}
			});
			ChannelFuture futrue = b.connect("localHost", 1043).sync();
			System.out.println("ChannelFutrue connected");
			futrue.channel().closeFuture().sync();
			System.out.println("ChannelFutrue closeFuture");
		}finally {
			workerGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
