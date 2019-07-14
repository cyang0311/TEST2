package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 返回响应协议
 */
public class Server03 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server03 server = new Server03();
        server.start();
    }


    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败！");
        }
    }
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立连接！");

//            InputStream is = client.getInputStream();
//            byte[] datas = new byte[1024*1024];
//            int len = is.read(datas);
//            String requestInfo = new String(datas,0,len);
//            System.out.println(requestInfo);
            Request request2 = new Request(client);
            Response response = new Response(client);
            Servlet servlet = WebApp.getServerFromUrl(request2.getUrl());
            if (servlet!=null){
                servlet.service(request2,response);
                response.pushToBrowser(200);
            }else {
                //错误
                response.pushToBrowser(404);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误！");
        }
    }
    public void stop(){

    }
}
