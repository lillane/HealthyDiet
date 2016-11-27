import com.healthydiet.*;
import com.healthydiet.entity.User;

/**
 *
 * Created by Яна on 29.10.2016.
 */
public class Auth {
    private static User currentUser;
    //метод, чтоб залогинить пользователя
    public static boolean doLogin (String username, String password){
        //currentUser = User.findByUsernameAndPassword(username, password);
        return isAuthorised();
    }

    //метод, чтоб выйти из системы
    public static void doLogout (){
        currentUser = null;
    }
    // метод для получения текущего пользователя
    public static User getCurrentUser(){
        return currentUser;
    }

    // метод для проверки залогинен ли пользователь или нет
    public static boolean isAuthorised(){
        if (currentUser!=null){
            return true;
        }
        return false;
    }
}
