package SaxXml.Server2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

public class Request {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //请求参数
    private String  queryStr;
    //存储参数
    private Map<String,List<String>> parameterMap;
    private static final String CRLF = "\r\n";

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream is){
        parameterMap = new HashMap<String,List<String >>();

        byte[] datas = new byte[1024*1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            System.out.println("111");
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
        this.url.trim();
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
        //转成Map
        convertMap();
    }
    //处理请求参数为Map
  private void convertMap(){
        //aaa=1&aaa=2&bbb=3
      String[] keyValues = this.queryStr.split("&");
      //aaa=1
      for (String query:keyValues) {
          String[] kv = query.split("=");
          kv= Arrays.copyOf(kv,2);
          //获取key和value
          String key = kv[0];
          String value = kv[1]==null?null:decode(kv[1],"utf-8");
          //存到Map中
          if (!parameterMap.containsKey(key)){
              //key第一次出现
              parameterMap.put(key,new ArrayList<String>());
          }
          parameterMap.get(key).add(value);
      }
  }
  //处理中文
  private String decode(String value,String enc){
      try {
          return java.net.URLDecoder.decode(value,enc);
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
          return null;
      }

  }

  //根据name获取多个value
  public String[] getParameterValues(String key){
        List<String> values = this.parameterMap.get(key);
        if (values==null || values.size()<1) {
            return null;
        }
        return values.toArray(new String[0]);
    }
    //获取一个value
    public String getParameter(String key){
        String[] values = getParameterValues(key);
        return values==null?null:values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }

}
