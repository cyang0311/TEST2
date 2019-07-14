package thread0;

/**
 * 代理
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
    interface Merry{
        void happyMarry();
    }
    static class You implements Merry{

        @Override
        public void happyMarry() {
            System.out.println("我结婚");
        }
    }
    static class WeddingCompany implements Merry{
        private Merry target;
        public WeddingCompany(Merry target){
            this.target=target;
        }
        @Override
        public void happyMarry() {
            ready();
            this.target.happyMarry();
            after();
        }
        private void ready(){
            System.out.println("准备");
        };
        private void after(){
            System.out.println("结束");
        }
    }
}
