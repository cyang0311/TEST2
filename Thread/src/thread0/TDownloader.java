package thread0;

public class TDownloader extends Thread{
    private String url;//图片资源路径
    private String name;//存储名字
    public TDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
    }
}
