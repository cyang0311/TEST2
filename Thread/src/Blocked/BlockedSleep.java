package Blocked; /**
 * 暂停，运行状态-->带资源进入阻塞状态-->暂停结束-->就绪状态
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedSleep{

    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis()+1000*10);
        long end = endTime.getTime();
        System.out.println("end"+end+"     endtime:"+endTime);
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if (end-10000>endTime.getTime()){
                break;
            }
        }
    }
}
