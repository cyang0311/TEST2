package Sync;

import java.util.concurrent.CopyOnWriteArrayList;

public class SyncTest030 {
    public static void main(String[] args) throws InterruptedException {
        //并发容器
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                //同步块
                    list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
