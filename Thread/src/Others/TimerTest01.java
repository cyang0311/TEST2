package Others;

import java.util.*;

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar cal = new GregorianCalendar(2019,4,27,18,26);
//        timer.schedule(new MyTask(),1000);//延时1s执行
//        timer.schedule(new MyTask(),1000,2000);//延时一秒，每两秒执行一次
        timer.schedule(new MyTask(),cal.getTime(),2000);//指定时间开始，每两秒执行一次

    }
}
//具体任务
class MyTask extends TimerTask{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("hello word");
        }
        System.out.println("-------end-------");
    }
}
