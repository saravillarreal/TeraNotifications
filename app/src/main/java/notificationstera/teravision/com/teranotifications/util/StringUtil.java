package notificationstera.teravision.com.teranotifications.util;

/**
 * Created by Sara Villarreal on 6/6/2016.
 */
public class StringUtil {

    public static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static boolean isValidEmail(String email) {
        if (email.matches(emailPattern))
            return true;
        return false;
    }

}
