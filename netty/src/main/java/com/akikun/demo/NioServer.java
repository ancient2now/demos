package com.akikun.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author 李俊秋(龙泽)
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8888));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey sscKey = ssc.register(selector, 0, null);
        sscKey.interestOps(SelectionKey.OP_ACCEPT);

        System.out.println("注册上selector ...");

        while (true) {
            selector.select();
            System.out.println("触发OP事件 ...");
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    System.out.println("执行Accept操作 ...");
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel channel = serverChannel.accept();
                    channel.configureBlocking(false);
                    SelectionKey cKey = channel.register(selector, 0, null);
                    cKey.interestOps(SelectionKey.OP_READ);
                }

                if (key.isReadable()) {
                    System.out.println("执行Read操作 ...");
                    ByteBuffer buffer = ByteBuffer.allocate(64);
                    SocketChannel channel = (SocketChannel) key.channel();
                    int read = channel.read(buffer);
                    if (read < 0) {
                        channel.close();
                        System.out.println();
                    } else {
                        buffer.flip();
                        System.out.println(StandardCharsets.UTF_8.decode(buffer).toString());
                        buffer.clear();
                    }
                }

                it.remove();
            }
        }


    }
}
