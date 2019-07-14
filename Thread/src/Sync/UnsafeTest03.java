package Sync;

import java.util.ArrayList;
import java.util.List;

/*
不安全线程  操作容器
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
