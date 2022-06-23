import user.User;
import user.UserService;
public class Main {

    public static void main(String[] args) {
        User ivan = new User("qwrаty_90", "trava13", "trava13");
        UserService.check(ivan);
    }
}