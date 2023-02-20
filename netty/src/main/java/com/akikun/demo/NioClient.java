package com.akikun.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author 李俊秋(龙泽)
 */
public class NioClient {

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(8888));
        System.in.read();
    }
}
