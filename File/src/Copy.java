import java.io.*;

public class Copy {
    public static void Copy(String srcPath, String destPath) {
        //创建源
        File src = new File(srcPath);
        File dest = new File(destPath);
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //操作，分段读取
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Copy("File/p.png","File/b.png");
    }
}
