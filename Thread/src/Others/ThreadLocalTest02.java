package Others;

/**
 * 每个线程存储自己的数据  更改不会影响其他的
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"--得到了-->"+threadLocal.get());
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"--还剩下-->"+threadLocal.get());
        }
    }
}
