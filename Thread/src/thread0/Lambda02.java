package thread0;

public class Lambda02 {

    public static void main(String[] args) {
        ILove love =(a)->{
            System.out.println("i love -->"+a);
        };
        love.lambda(100);
        /////////////
        love =a->{
            System.out.println("i love -->"+a);
        };
        love.lambda(50);
        ////////////
        love = a-> System.out.println("i love -->"+a);
        love.lambda(0);
    }

}

interface ILove {
    void lambda(int a);
}

//外部类
class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("i love lambda-->"+a);
    }
}
