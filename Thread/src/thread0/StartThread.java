package thread0;

public class StartThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("线程：-->"+i);
        }
    }

    public static void main(String[] args) {
//        //创建实现类对象
//        thread0.StartThread sd = new thread0.StartThread();
//        //创建代理类对象
//        Thread t = new Thread(sd);
//        t.start();
        new Thread(new StartThread()).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程：-->"+i);
        }
    }
}
