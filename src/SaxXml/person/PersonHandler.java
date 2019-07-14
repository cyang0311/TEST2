package SaxXml.person;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档");
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("开始解析元素"+qName);
        if (qName!=null){
            tag = qName;
        }
        if (tag.equals("person")){
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if (tag!=null){
            if(tag.equals("name")){
                person.setName(contents);
            }else if (tag.equals("age")){
                if (contents.length()>0){
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束解析元素"+qName);
        if (qName!=null){
            if (qName.equals("person")){
                persons.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束解析文档");
    }
}
