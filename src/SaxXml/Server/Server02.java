package SaxXml.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 返回响应协议
 */
public class Server02 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server02 server = new Server02();
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
            Request request = new Request(client);
            Response response = new Response(client);

            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("正文");
            response.print("</body>");
            response.print("</html>");

            response.pushToBrowser(200);
//            int size = content.toString().getBytes().length;
//            StringBuilder responseInfo = new StringBuilder();
//            String blank = " ";
//            String CRLF = "\r\n";
//            //状态行
//            //响应行 HTTP/1.1 200 OK
//            responseInfo.append("HTTP/1.1").append(blank).append("200").append(blank);
//            responseInfo.append("OK").append(CRLF);
//            //响应头(结尾有空行)
//            /**Date:
//             * Server:    ；charset=GBK
//             * Content-Type: text/plain;
//             * Content-Length: 22
//             */
//            responseInfo.append("Date:").append(new Date()).append(CRLF);
//            responseInfo.append("Server").append("Server/cy;charset=GBK").append(CRLF);
//            responseInfo.append("Content-Type:").append("text/html").append(CRLF);
//            responseInfo.append("Content-Length:").append(size).append(CRLF);
//            responseInfo.append(CRLF);
//            //正文
//            responseInfo.append(content.toString());
//            //写出到客户端
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//            bw.write(responseInfo.toString());
//            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误！");
        }
    }
    public void stop(){

    }
}
