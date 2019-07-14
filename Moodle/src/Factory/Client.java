package Factory;

/**
 * 抽象工厂模式
 */
public class Client {
    public static void main(String[] args) {
        Factory factory1 = new TCLFactory();
        Factory factory2 = new HaierFactory();


        factory1.createConditioner().display();
        factory1.createTv().display();

        factory2.createConditioner().display();
        factory2.createTv().display();

    }
}
