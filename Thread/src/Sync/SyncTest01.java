package Sync;

/**
 * synchronized锁
 * 1.同步方法
 * 2.同步块
 */
public class SyncTest01 {

    public static void main(String[] args) {
        SafeWeb12306 wb = new SafeWeb12306();
        new Thread(wb,"AAA").start();
        new Thread(wb,"BBB").start();
        new Thread(wb,"CCC").start();
    }
}
class SafeWeb12306 implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test();
        }
    }
    public synchronized void test(){//锁了对象资源this
        if (ticketNum<0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  "+ticketNum--);
    }
}