package SaxXml.Server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    //正文
    private StringBuilder content;
    //协议头
    private StringBuilder headInfo;
    private BufferedWriter bw;
    private int len ;
    private final String blank = " ";
    private final String CRLF = "\r\n";

    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }

    }
    public Response(OutputStream os){

    }

    //动态添加内容
    public Response print(String info){
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }
    public Response println(String  info){
        content.append(info).append(CRLF);
        len+=(info+CRLF).getBytes().length;
        return this;
    }


    //构建头信息
    private void createHeadInfo(int code){

        //状态行
        //响应行 HTTP/1.1 200 OK
        headInfo.append("HTTP/1.1").append(blank);
        headInfo.append(code).append(blank);
        switch (code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("Not FOUND").append(CRLF);
                break;
            case 500:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        //响应头(结尾有空行)
        /**Date:
         * Server:    ；charset=GBK
         * Content-Type: text/plain;
         * Content-Length: 22
         */
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("Server/cy;charset=UTF-8").append(CRLF);
        headInfo.append("Content-Type:").append("text/html").append(CRLF);
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
    //推送头信息
    public void pushToBrowser(int code) throws IOException {
        if (headInfo==null){
            code=505;
        }
        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }
}
