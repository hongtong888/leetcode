import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

    public static void main(String[] args) throws IOException {
        //获取一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        //提供服务器ip 和端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if (!socketChannel.connect(address)){
            //未连接上
            while (!socketChannel.finishConnect()){
                System.out.println("连接需要时间，客户端不会阻塞，可以做其他的事情");
            }
        }
        //连接成功
        String str = "连接成功";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //拿到数据写入到socketChannel
        socketChannel.write(byteBuffer);
    }
}
