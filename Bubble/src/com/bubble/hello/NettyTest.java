package com.bubble.hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class NettyTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("line.separator"));
		ServerBootstrap sb = new ServerBootstrap();
		sb.group(new NioEventLoopGroup());
		
		new LineBasedFrameDecoder(1024);
		
	}
}
