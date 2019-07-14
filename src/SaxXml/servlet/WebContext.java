package SaxXml.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
    private List<Entity> entitys = null;
    private List<Mapping> mappings = null;

    //<key,value>---><url-pattern,servlet-name>
    private Map<String,String> mappingMap = new HashMap<String,String>();
    //<key,value>---><servlet-name,servlet-class>
    private Map<String,String> entityMap = new HashMap<String,String>();

    public WebContext(List<Entity> entitys, List<Mapping> mappings) {
        this.entitys = entitys;
        this.mappings = mappings;
        // 将mapping的List转成对应Map
        for (Mapping mapping:mappings) {
            for (String pattern:mapping.getPatterns()) {
                mappingMap.put(pattern,mapping.getName());
            }
        }
        //将entity的List转成对应Map
        for (Entity entity:entitys) {
            entityMap.put(entity.getName(),entity.getClz());
        }
    }

    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
