package com.akikun.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 李俊秋(龙泽)
 */
public class BioServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8088));
        System.out.println("accept before");
        SocketChannel sc = ssc.accept();
        System.out.println("accept after");

        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (true) {
            System.out.println("read before");
            sc.read(buffer);

            buffer.flip();
            String v = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println(v);
            System.out.println("read after");

            buffer.clear();
        }

    }
}
