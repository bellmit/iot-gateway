package com.newbig.im.core.client;

//import com.newbig.im.core.proto.SocketASK;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel ch) {
        ch.pipeline().addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
//        ch.pipeline().addLast("decoder", new ProtobufDecoder(SocketASK.getDefaultInstance()));
        ch.pipeline().addLast("fieldPrepender", new ProtobufVarint32LengthFieldPrepender());
        ch.pipeline().addLast("encoder", new ProtobufEncoder());
        ch.pipeline().addLast(new ClientHandler());
    }

}

