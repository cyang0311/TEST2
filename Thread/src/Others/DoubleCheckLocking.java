package Others;

import java.awt.*;

/**
 * DCL单例模式  双重检测
 *
 */
public class DoubleCheckLocking {
    //私有的静态属性  不加volatile可能会导致其他线程获取到一个正在初始化的对象
    private volatile static DoubleCheckLocking instance;

    //构造器私有
    private DoubleCheckLocking(){

    }
    //公共静态方法
    public static DoubleCheckLocking getInstance(long time){
        if (instance != null){
            return instance;
        }
        synchronized (DoubleCheckLocking.class){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (instance == null){
                instance = new DoubleCheckLocking();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckLocking.getInstance(0));
        });
        t.start();
        new Thread(()->{
            System.out.println(DoubleCheckLocking.getInstance(0));
        }).start();
    }
}
