package com.core.handler;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.core.net.IProtoToID;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 参考ProtobufVarint32FrameDecoder 和 ProtobufDecoder
 */

public class CustomProtobufDecoder extends ByteToMessageDecoder {
	private static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(CustomProtobufDecoder.class.getName());
	private IProtoToID customProtoToID;

	public CustomProtobufDecoder(IProtoToID customProtoToID) {
		this.customProtoToID = customProtoToID;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		while (in.readableBytes() > 2) { // 如果可读长度小于包头长度，退出。
			in.markReaderIndex();

			// 获取包头中的body长度
			int length = in.readShort();
			// 如果可读长度小于body长度，恢复读指针，退出。
			if (in.readableBytes() < length) {
				in.resetReaderIndex();
				return;
			}

			// 获取包头中的protobuf类型
			int msgType = in.readShort();
			int tag = in.readInt();
			length -= 6;

			// 读取body
			ByteBuf bodyByteBuf = in.readBytes(length);

			byte[] array;
			int offset;

			int readableLen = bodyByteBuf.readableBytes();
			if (bodyByteBuf.hasArray()) {
				array = bodyByteBuf.array();
				offset = bodyByteBuf.arrayOffset() + bodyByteBuf.readerIndex();
			} else {
				array = new byte[readableLen];
				bodyByteBuf.getBytes(bodyByteBuf.readerIndex(), array, 0, readableLen);
				offset = 0;
			}

			// 反序列化
			MessageLite result = decodeBody(msgType, array, offset, readableLen);
			if (null != result) {
				out.add(new ProtoData(msgType, result));
			} else {
				LOG.error("can't get msg by type :" + msgType);
			}
		}
	}

	public MessageLite decodeBody(int dataType, byte[] array, int offset, int length) throws Exception {
		GeneratedMessageV3 generatedMessage = customProtoToID.getMesByID(dataType);
		if (null == generatedMessage) {
			return null;
		} else {
			return generatedMessage.getParserForType().parseFrom(array, offset, length);
		}
	}
}