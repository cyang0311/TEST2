package Sync;

public class SyncTest02 {
    public static void main(String[] args) {
        Account account = new Account(100,"礼金");
        SyncDrawing you = new SyncDrawing(account,80,"you");
        SyncDrawing wife = new SyncDrawing(account,90,"wife");

        you.start();
        wife.start();
    }
}
//账户

//取钱
class SyncDrawing extends Thread{
    Account account;//取钱账户
    public int drawingMoney;//取钱数
    public int packetTotal;//取钱总数

    public SyncDrawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
       test();
    }
    public  void test(){//锁了取款机，对象错误，失败
        //提高性能，
        if (account.money<=0){
            return;
        }
        synchronized (account){//块锁  锁account对象
            if (account.money-drawingMoney<0){
                return;
            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            account.money-=drawingMoney;
            packetTotal+=drawingMoney;
            System.out.println(this.getName()+"-->账户余额:"+account.money);
            System.out.println(this.getName()+"-->口袋余额:"+packetTotal);
        }
    }
}