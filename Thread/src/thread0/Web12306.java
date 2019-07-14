package thread0;

public class Web12306 implements Runnable{
    /**
     * 存在并发问题
     */
    private int ticketNum = 99;
    @Override
    public void run() {
        while(true){
            if (ticketNum<0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+ticketNum--);
        }
    }

    public static void main(String[] args) {
        Web12306 wb = new Web12306();
        new Thread(wb,"AAA").start();
        new Thread(wb,"BBB").start();
        new Thread(wb,"CCC").start();
    }
}
