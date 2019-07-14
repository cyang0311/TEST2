public class User {
    private String name;
    private static User user ;

    private User(){}
    public static User GetInstance() {
        if (user==null){
            user = new User();
        }
        return user;
    }
}
class test2{
    User user = User.GetInstance();
}