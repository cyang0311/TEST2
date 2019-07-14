package Others;

/**
 * volatile用于数据同步，数据被修改将主存立即同步，只同步数据
 * 防止指令重排  导致结果错误
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
        }).start();
        Thread.sleep(1000);
        num = 1;
    }
}
