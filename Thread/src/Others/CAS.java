package Others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 比较并交换
 */
public class CAS {
    //库存
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->{
                Integer left = stock.decrementAndGet();
                System.out.println(Thread.currentThread().getName()+"-->抢了一件商品");
                System.out.println("剩余-->"+left);
                if (left < 1){
                    System.out.println("抢完了");
                    return;
                }
            }).start();
        }
    }
}
