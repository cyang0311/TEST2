package SaxXml.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class Request {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //请求参数
    private String  queryStr;

    private static final String CRLF = "\r\n";

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream is){

        byte[] datas = new byte[1024*1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }
    private void parseRequestInfo(){
        System.out.println("分解");
//        System.out.println(requestInfo);

        //获取请求方式
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
        //获取请求url
        int startIdx = this.requestInfo.indexOf("/")+1;
        int stopIdx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startIdx,stopIdx);
        //获取？位置
        int queryIdx = this.url.indexOf("?");
        if (queryIdx>=0){
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0].trim();
            this.queryStr = urlArray[1].trim();
        }
        queryStr = null ==queryStr?"":queryStr;
        if (method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (queryStr==""){
                queryStr = qStr;
            }else {
                queryStr += "&"+qStr;
            }
        }
        System.out.println(method);
        System.out.println(url);
        System.out.println(queryStr);
    }
}
