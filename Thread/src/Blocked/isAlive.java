package Blocked;

public class isAlive {
    public static void main(String[] args) throws InterruptedException {
        MyInfo myInfo = new MyInfo("角色名");
        Thread t = new Thread(myInfo,"代理名");
        System.out.println(Thread.currentThread().isAlive());
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}
class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+this.name);
    }
}