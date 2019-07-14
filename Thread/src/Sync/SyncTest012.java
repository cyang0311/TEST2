package Sync;

public class SyncTest012 {
    public static void main(String[] args) {
        SafeWeb212306 wb = new SafeWeb212306();
        new Thread(wb,"AAA").start();
        new Thread(wb,"BBB").start();
        new Thread(wb,"CCC").start();
    }
}
class SafeWeb212306 implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test2();
        }
    }
    public  void test2() {//锁了对象资源this
        if (ticketNum <= 0) {//没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNum <= 0) {//最后一张票的情况
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  " + ticketNum--);
        }
    }
}
