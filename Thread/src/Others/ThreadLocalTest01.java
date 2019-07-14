package Others;

/**
 * ThreadLocal:每个线程自身的存储区域，局部
 * 方法：get  set  initialValue
 */
public class ThreadLocalTest01 {
//    private static ThreadLocal<Integer> threadLoca = new ThreadLocal<>();
    /**
     * 更改初始值  需要创建ThreadLocal的子类  重写initialValue
     */
//    匿名内部类
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
//        protected Integer initialValue() {
//            return 200;
//        }
// lambda
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 200;
    });

    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        //设置值
        threadLocal.set(100);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{

        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*101));
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
}
