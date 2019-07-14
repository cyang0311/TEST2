package thread0;

import java.util.concurrent.*;

public class CRacer implements Callable<Integer> {
    private static String winner;

    @Override
    public Integer call() throws Exception {
        for (int steps = 1; steps <= 100; steps++) {
            //模拟睡眠
            if (Thread.currentThread().getName().equals("pool-1-thread-2") && steps % 10 == 0) {
                Thread.sleep(10);
            }
            System.out.println(Thread.currentThread().getName() + "-->" + steps);
            boolean flag = gameOver(steps);
            if (flag) {
                return steps;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();

        //创建服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //移交执行
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);
        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1+"   "+r2);
        //关闭服务
        ser.shutdownNow();
    }
}
