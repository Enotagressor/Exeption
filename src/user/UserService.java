package user;

import exception.WrongLoginException;
import exception.WrongPasswordException;

public class UserService extends User {
    public UserService(String login, String password, String confirmPassword) {
        super(login, password, confirmPassword);
    }

    public static boolean check(User users) {
        try {
            UserService.checkUser(users.getLogin(), users.getPassword(), users.getConfirmPassword());
        } catch (WrongLoginException | WrongPasswordException e) {
            return false;
        } finally {
            System.out.println("GOOD BAY");
        }
            return true;
    }

    private static void checkUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        String exmp = "QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm0123456789_";
        String[] log = login.split("");
        String[] pas = password.split("");


        for (int i = 0; i < log.length; i++) {
            if (!exmp.contains(log[i]) || login.length() > 19) {
                throw new WrongLoginException("Логин не соответствует требованиям");
            }
        }
        for (int i = 0; i < pas.length; i++) {
            if (!exmp.contains(pas[i]) || password.length() >= 19) {
                throw new WrongPasswordException("Пароль не соответствует требованиям");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введены разные пароли");
        }
    }
}
