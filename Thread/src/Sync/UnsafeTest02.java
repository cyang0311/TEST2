package Sync;

public class UnsafeTest02 {
    public static void main(String[] args) {
        Account account = new Account(100,"礼金");
        Drawing you = new Drawing(account,80,"you");
        Drawing wife = new Drawing(account,90,"wife");

        you.start();
        wife.start();
    }
}

//取钱
class Drawing extends Thread{
    Account account;//取钱账户
    public int drawingMoney;//取钱数
    public int packetTotal;//取钱总数

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        if (account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingMoney;
        packetTotal+=drawingMoney;
        System.out.println(this.getName()+"-->账户余额:"+account.money);
        System.out.println(this.getName()+"-->口袋余额:"+packetTotal);
    }
}
