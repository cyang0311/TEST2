package Sync;

import java.util.ArrayList;
import java.util.List;

public class SyncTest03 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                //同步块
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(list.size());
    }
}
