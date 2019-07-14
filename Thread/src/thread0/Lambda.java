package thread0;

public class Lambda {

    static class Like2 implements ILike {
        public void lambda() {
            System.out.println("lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
        like = new Like2();
        ((Like2) like).lambda();

        class Like3 implements ILike {
            public void lambda() {
                System.out.println("lambda3");
            }
        }
        like = new Like3();
        ((Like3) like).lambda();

        //匿名内部类
        like = new ILike() {
            public void lambda() {
                System.out.println("lambda4");
            }
        };
        like.lambda();
        //lambda
        like = () -> {
            System.out.println("lambda5");
        };
        like.lambda();
    }

}

interface ILike {
    void lambda();
}

//外部类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("lambda");
    }
}
