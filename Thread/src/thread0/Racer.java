package thread0;

public class Racer implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            //模拟睡眠
            if (Thread.currentThread().getName().equals("tz")&&steps%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            boolean flag = gameOver(steps);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        if (winner!=null){
            return true;
        }else {
            if (steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("WINNER:-->"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"wb").start();
        new Thread(racer,"tz").start();
    }
}
