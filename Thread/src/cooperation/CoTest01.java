package cooperation;

/**
 * 协作模型  生产者消费者模式 1、管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();
        new Producers(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producers extends Thread{
    SyncContainer container;

    public Producers(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 20; i++) {
            System.out.println("生产-->"+i+"馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("消费-->"+container.pop().id+"馒头");
        }
    }
}
//缓冲区
class SyncContainer{
    Steamedbun[] buns = new Steamedbun[10];//容器
    int count = 0;//计数器
    //存
    public synchronized void push(Steamedbun bun){
        //有数据
        if (count==buns.length){
            try {
                this.wait();//容器满  线程阻塞  等待通知
            } catch (InterruptedException e) {
            }
        }
        //没数据
        buns[count] = bun;
        count++;
        this.notifyAll();
    }
    //取
    public synchronized Steamedbun pop(){
        //没有数据  等待
        if (count==0){
            try {
                this.wait();//线程阻塞 等待通知解除
            } catch (InterruptedException e) {
            }
        }
        //有数据
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();
        return bun;
    }
}
//数据对象
class Steamedbun{
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }
}