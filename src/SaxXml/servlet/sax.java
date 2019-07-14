package SaxXml.servlet;
import SaxXml.person.Person;
import SaxXml.person.PersonHandler;
import SaxXml.servlet.Entity;
import SaxXml.servlet.Mapping;
import SaxXml.servlet.WebContext;
import SaxXml.servlet.WebHandler;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class sax {
    public static void main(String[] args) throws Exception {
        //获取解析工厂
        SAXParserFactory factory =SAXParserFactory.newDefaultInstance();
        //从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //编写处理器
        //加载文档Document注册处理器
//        PersonHandler handler = new PersonHandler();
        WebHandler handler = new WebHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("SaxXml/servlet/web.xml"),handler);

        WebContext context = new WebContext(handler.getEntitys(),handler.getMappings());

        String className = context.getClz("/login");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        servlet.service();
//        for (Entity e:context.entitys) {
//            System.out.println(e.getName()+"-->"+e.getClz());
//        }
//        for (Mapping m:context.mappings) {
//            System.out.println(m.getName()+"-->"+m.getPatterns());
//        }
    }
}

