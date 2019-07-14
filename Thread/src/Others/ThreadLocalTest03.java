package Others;
/**
 *InheritableThreadLocal继承上下文的值  拷贝给子线程
 */
public class ThreadLocalTest03 {

    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }).start();
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
    }

}
