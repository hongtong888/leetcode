package com.ht.io.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {
    public static void main(String[] args) throws Exception {
        URL url = ClassLoader.getSystemClassLoader().getResource("demo.txt");
        FileInputStream inputStream = new FileInputStream(url.getPath());

        FileChannel channel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(20);

        //先将数据读取到缓冲区中
        channel.read(buffer);
        output("调用read()",buffer);

        //准备操作前锁定目标范围
        buffer.flip();
        output("调用flip()",buffer);

        //判断有没有可读数据
        while (buffer.remaining()>0){
            byte b = buffer.get();
//            System.out.println((char) b);
        }
        output("调用get()",buffer);

        buffer.clear();
        output("调用clear()",buffer);

        inputStream.close();

    }

    public static void output(String step, Buffer buffer){
        System.out.println(step + ":");
        System.out.print("capacity:" + buffer.capacity()+"。");
        System.out.print("position:" + buffer.position()+"。");
        System.out.print("limit:" + buffer.limit()+"。");
        System.out.println();
    }
}
