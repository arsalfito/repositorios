package co.gov.archivo.indicadores.util;

public class PasswordUtil {

	public static boolean isValidPassword(String password) {
        return password.matches(RegexUtil.PASSWORD) && !password.matches(RegexUtil.PASSWORD_SEQUENCE_NUMBER);
    }
}
