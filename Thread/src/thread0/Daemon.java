package thread0;
/*
守护线程
jvm需要等用户线程结束才会停止   但不会等守护线程结束
 */
public class Daemon {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread t = new Thread(god);
        t.setDaemon(true);//从用户线程改为守护线程
        t.start();
        new Thread(you).start();
    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 365*100; i++) {
            System.out.println("you");
        }
    }
}
class God implements Runnable{

    @Override
    public void run() {
        for (;true;){
            System.out.println("god");
        }
    }
}