package com.ht.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {

    private final String HOST = "127.0.0.1";

    private final int PORT = 6667;

    private Selector selector;

    private SocketChannel socketChannel;

    private String username;

    public GroupChatClient() throws IOException {
        selector = Selector.open();

        socketChannel= socketChannel.open(new InetSocketAddress(HOST,PORT ));

        socketChannel.configureBlocking(false);

        socketChannel.register(selector,SelectionKey.OP_READ);

        username = socketChannel.getLocalAddress().toString().substring(1);

        System.out.println(username + "is ok....");
    }

    //向服务器发送消息
    public void sendMsg(String msg){
        msg = username + "发送的消息" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务从服务端回复的消息
    public void readMsg(){
        try {
            int readSelect = selector.select();
            if (readSelect > 0 ){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (key.isReadable()){
                        SocketChannel channel = (SocketChannel)key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg.trim());
                    }
                }
            }else{
                System.out.println("没有可用的通道");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception {
        final GroupChatClient chatClient = new GroupChatClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    chatClient.readMsg();
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
