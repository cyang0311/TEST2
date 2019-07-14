package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatcher implements Runnable{
    private Socket client;
    Request request;
    Response response;
    public Dispatcher(Socket client){
        this.client = client;
        try {
            //获取请求.响应协议
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }
    @Override
    public void run() {
        try{
            if (request.getUrl().equals("")||request.getUrl()==null){
                InputStream is =  Thread.currentThread().getContextClassLoader().getResourceAsStream("login.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(200);
                is.close();
                this.release();
                return;
            }
            Servlet servlet = WebApp.getServerFromUrl(request.getUrl());
            if (servlet!=null){
                servlet.service(request,response);
                response.pushToBrowser(200);
            }else {
                //错误
                InputStream is =  Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(404);
                is.close();
                this.release();
            }
        }catch (Exception e){
            try {
                response.pushToBrowser(500);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        release();
    }
    private void release(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
