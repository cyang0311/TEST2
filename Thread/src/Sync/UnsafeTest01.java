package Sync;
/**
 * 存在并发问题
 */
public class UnsafeTest01 {

    public static void main(String[] args) {
        Unsafe12306 wb = new Unsafe12306();
        new Thread(wb,"AAA").start();
        new Thread(wb,"BBB").start();
        new Thread(wb,"CCC").start();
    }
}
class Unsafe12306 implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            test();
        }
    }
    public void test(){
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