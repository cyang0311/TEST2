package Factory;

public class TCLFactory implements Factory{
    @Override
    public Tv createTv() {
        return new TCLTv();
    }

    @Override
    public Conditioner createConditioner() {
        return new TCLConditioner();
    }
}
