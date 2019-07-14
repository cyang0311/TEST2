package core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
    private static  WebContext webContext;
    static {
        try{
            //获取解析工厂
            SAXParserFactory factory =SAXParserFactory.newDefaultInstance();
            //从解析工厂获取解析器
            SAXParser parser = factory.newSAXParser();
            //编写处理器
            //加载文档Document注册处理器
            WebHandler handler = new WebHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),handler);
            webContext= new WebContext(handler.getEntitys(),handler.getMappings());
        }catch (Exception e){
            System.out.println("解析文件错误");
        }
    }

    /**
     * 通过url获取配置文件对应servlet
     *
     */
    public static Servlet getServerFromUrl(String url){
        String className = webContext.getClz("/"+url);
        Class clz;
        try{
            clz = Class.forName(className);
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();
            return servlet;
        }catch (Exception e){
            System.out.println("解析文件错误");
        }
        return null;
    }
}
