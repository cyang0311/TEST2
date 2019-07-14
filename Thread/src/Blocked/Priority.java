package Blocked;

/**
 * 设置优先级,范围1-10，默认为5
 * 概率   高的不一定先执行
 */
public class Priority {
    public static void main(String[] args) {
        PriorityTest pt = new PriorityTest();
        Thread t1 = new Thread(pt,"T1");
        Thread t2 = new Thread(pt,"T2");
        Thread t3 = new Thread(pt,"T3");
        Thread t4 = new Thread(pt,"T4");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class PriorityTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        Thread.yield();
    }
}