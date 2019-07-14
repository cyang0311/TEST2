package cooperation;
/*
协作模型  生产者消费者模式 1、信号灯法
借助标志位
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
//演员生产者
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("地下城");
            }else{
                this.tv.play("英雄联盟");
            }
        }

    }
}
//观众消费者
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}
class Tv{
    String voice;
    boolean flag = true;
    //true  演员表演 观众等待
    //false 观众观看 演员等待

    //表演
    public synchronized void play(String voice){
        //演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        //演员表演
        this.voice = voice;
        System.out.println("表演了:"+voice);
        flag = !flag;
        this.notifyAll();
    }

    //观看
    public synchronized void watch(){
        //观众等待
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        //观众观看
        System.out.println("观看了:"+voice);
        flag = !flag;
        this.notifyAll();
    }
}