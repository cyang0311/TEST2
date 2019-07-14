package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 加入分发器  多线程处理
 */
public class Server08 {
    private ServerSocket serverSocket;
    private Boolean isRunning;
    public static void main(String[] args) {
        Server08 server = new Server08();
        server.start();
    }


    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            System.out.println("启动start");
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败！");
        }
    }
    public void receive(){
        while (isRunning){
            try {
                Socket client = serverSocket.accept();
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端错误！");
                stop();
            }
        }
    }
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
