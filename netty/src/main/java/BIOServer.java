import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws Exception {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //建立一个socket连接
        ServerSocket socket = new ServerSocket(6666);

        System.out.println("服务器已启动");

        //监听等待客户端的连接
        while (true){
            final Socket accept = socket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                public void run() {
                    hanlerAccept(accept);
                }
            });
        }
    }

    private static void hanlerAccept(Socket accept) {
        //通过连接获取到输入流
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = accept.getInputStream();
            //从输入流中读取数据
            while (true){
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("关闭和client的连接");
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
