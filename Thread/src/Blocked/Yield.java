package Blocked;

/**
 * 礼让，暂停程序，直接到就绪状态
 */
public class Yield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"-->end");
    }
}