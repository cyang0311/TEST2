package Blocked;
/*
Join  插队线程
 */
public class Join {
    public static void main(String[] args) {
        System.out.println("买烟故事");
        Thread t = new Father();
        t.start();
    }
}
class Father extends Thread{
    @Override
    public void run() {
        System.out.println("烟没了，让儿子买");
        Thread t = new Thread(new Son());

        t.start();
        try {
            t.join();//father被阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("爸爸抽烟");
    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("拿着爸爸的钱出门");
        System.out.println("玩10秒");
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1+"秒过去了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧去买烟");
        System.out.println("带烟回家");
    }
}