package Others;

import jdk.swing.interop.SwingInterOpUtils;

/**
 *
 */
public  class LockTest01 {
    public void test(){

        synchronized (this){
            System.out.println("第一次获得锁");
            while (true){
                synchronized (this){
                    System.out.println("第二次获得锁");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest01().test();
    }

}
