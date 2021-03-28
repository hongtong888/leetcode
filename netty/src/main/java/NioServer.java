import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {
        //创建serversocketchannl对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //获取到selector
        Selector selector = Selector.open();

        //绑定端口，服务端进行监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //在将serverSocketChannel 注册到selector上
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //然后循环监听
        while (true){
            //监听select()方法，返回已准备就绪的事件
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1s,没有任何链接");
                continue;
            }
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //判断不同的key做相应的事件处理
                if (selectionKey.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                }else if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    //获取该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
                    //读取buffer数据
                    channel.read(buffer);
                    System.out.println("from 客户端"+new String(buffer.array()));
                }
                iterator.remove();
            }

        }
    }
}
