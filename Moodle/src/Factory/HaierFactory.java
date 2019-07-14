package Factory;

public class HaierFactory implements Factory{
    @Override
    public Tv createTv() {
        return new HaierTv();
    }

    @Override
    public Conditioner createConditioner() {
        return new HaierConditioner();
    }
}
