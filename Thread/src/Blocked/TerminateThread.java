package Blocked;

public class TerminateThread implements Runnable{
    /**
     * 终止线程
     * @param args
     */
    private boolean flag = true;
    private String name;
    private int i=0;

    public TerminateThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(flag){
            System.out.println(name+"-->"+i++);
        }
    }

    public void Terminate(){
        this.flag = true;
    }

}
class test{
    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("CC");
//        new Thread(tt).start();

        for (int i = 0; i < 100; i++) {
            if (i%10==0){
                Thread.yield();
            }
            if (i==88){
                tt.Terminate();
                System.out.println("CC-->GameOver");
            }
            System.out.println("main-->"+i);
        }
    }
}
