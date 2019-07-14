package thread0;

/**
 * 实现Runnable
 */
public class IDownloader implements Runnable{
    private String url;//图片资源路径
    private String name;//存储名字
    public IDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }

    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("http://seopic.699pic.com/photo/40113/1486.jpg_wh1200.jpg","p1.jpg");
        TDownloader td2 = new TDownloader("http://seopic.699pic.com/photo/40112/3283.jpg_wh1200.jpg","p2.jpg");
        TDownloader td3 = new TDownloader("http://seopic.699pic.com/photo/40112/3169.jpg_wh1200.jpg","p3.jpg");

        //借助代理类对象,启动线程
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }
}
