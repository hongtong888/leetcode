package com.ht.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class GroupChatServer {

    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int port = 6667;

    //构造器的初始化工作
    public GroupChatServer(){
        try {
            //获取选择器
            selector = Selector.open();
            //获取serversocketchannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(port));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //循环监听
    public void listent(){
        while (true){
            try {
                int cout = selector.select(5000);
                if (cout >0 ){
                    //有时间发生
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        //如果是连接事件
                        if (key.isAcceptable()){
                            SocketChannel socketChannel = listenChannel.accept();
                            //进行注册
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ );
                            //提示上线
                            System.out.println(socketChannel.getRemoteAddress() + "上线");

                        }else if(key.isReadable()){
                            //可读事件
                            read(key);
                        }
                        iterator.remove();
                    }
                }else{
                    System.out.println("等待连接");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void read(SelectionKey key){
        SocketChannel channel = null;
        try {
            //通过注册事件获取到channel
            channel = (SocketChannel)key.channel();
            //创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //讲channel的数据读取到buffer
            int read = channel.read(byteBuffer);
            if (read >0){
                //把缓冲区的数据转成字符串
                String msg = new String(byteBuffer.array());
                //输出该消息
                System.out.println("from 客户端" + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.listent();
    }
}
