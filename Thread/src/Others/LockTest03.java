package Others;

/**
 * 可重入锁
 */
public class LockTest03 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a获得锁"+Thread.currentThread().getName());
        b();
        lock.unLock();
        System.out.println("a释放锁");
    }
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println("b获得锁"+Thread.currentThread().getName());
        lock.unLock();
        System.out.println("b释放锁");
    }

    class Lock{
        private boolean isLocked = false;
        private Thread lockedBy = null;//当前占用线程
        private int holdCount = 0;//锁计数器

        //获得锁
        public synchronized void lock() throws InterruptedException {
            Thread t = Thread.currentThread();
            while(isLocked&&lockedBy!=t){
                wait();
            }
            isLocked =true;
            lockedBy = t;
            holdCount ++;
        }
        //释放锁
        public synchronized void unLock(){
            if (Thread.currentThread()==lockedBy){
                holdCount --;
                if (holdCount == 0){
                    isLocked = false;
                    notify();
                    lockedBy = null;
                }
            }
        }

        public int getHoldCount() {
            return holdCount;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 lockTest03 = new LockTest03();
        lockTest03.a();
    }
}
