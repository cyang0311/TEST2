package Others;

/**
 * 不可重入锁
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a获得锁");
        b();
        lock.unlock();
    }
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println("b获得锁");
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
    }

    class Lock {
        private boolean isLocked = false;

        //使用锁
        public synchronized void lock() throws InterruptedException {
            while (isLocked) {
                wait();
            }
            isLocked = true;
        }
        //释放锁
        public synchronized void unlock(){
             isLocked = false;
             notify();
        }
    }
}
