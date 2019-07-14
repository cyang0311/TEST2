package thread0;

import java.util.concurrent.*;

/**
 * 实现Callable接口
 */
public class CDownloader implements Callable<Boolean> {
    private String url;//图片资源路径
    private String name;//存储名字
    public CDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1 = new CDownloader("http://seopic.699pic.com/photo/40113/1486.jpg_wh1200.jpg","p1.jpg");
        CDownloader cd2 = new CDownloader("http://seopic.699pic.com/photo/40112/3283.jpg_wh1200.jpg","p2.jpg");
        CDownloader cd3 = new CDownloader("http://seopic.699pic.com/photo/40112/3169.jpg_wh1200.jpg","p3.jpg");

        //创建服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //移交执行
        Future<Boolean> result1 = ser.submit(cd1);
        Future<Boolean> result2 = ser.submit(cd2);
        Future<Boolean> result3 = ser.submit(cd3);
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        //关闭服务
        ser.shutdownNow();
    }
}
