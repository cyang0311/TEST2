package GetClass;

import java.lang.reflect.InvocationTargetException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取class三种方式
        //1.对象.getClass()
        Phone phone = new Phone();

        Class clz = phone.getClass();
        //2.类.class()
        clz = Phone.class;
        //Class.forName("包名.类名")
        Class clz2 = Class.forName("GetClass.Phone");

        Phone phone1 = (Phone) clz2.getConstructor().newInstance();

        System.out.println(phone1);
        System.out.println(clz.getName());
    }
}
//sss
 class Phone{
    public Phone(){

    }
}
