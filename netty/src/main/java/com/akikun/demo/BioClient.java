package com.akikun.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @author 李俊秋(龙泽)
 */
public class BioClient {

    public static void main(String[] args) throws IOException {

        SocketChannel client = SocketChannel.open();
        client.connect(new InetSocketAddress(8088));
        System.in.read();
    }
}
