package com.ht.io.nio;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

public class FileOutputDemo {

    static private final byte message[] = {83,111,109,101,32,98,121,116,101,115,46};

    public static void main(String[] args) throws Exception {
        URL url = ClassLoader.getSystemClassLoader().getResource("test.txt");

        FileOutputStream out = new FileOutputStream(url.getPath());
        //开启一个channel
        FileChannel channel = out.getChannel();

        ServerSocketChannel server = ServerSocketChannel.open();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        for (int i = 0; i < message.length; i++) {
           buffer.put(message[i]);
        }

        buffer.flip();

        channel.write(buffer);

        out.close();
    }
}
