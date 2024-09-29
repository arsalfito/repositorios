package co.gov.archivo.indicadores.util;

public class RegexUtil {

	public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,}$";
    public static final String PASSWORD_SEQUENCE_NUMBER = "(01|12|23|34|45|56|67|78|89)+";
    public static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String NUMERIC = "^[0-9]+$";
    public static final String ALPHA = "^[A-Za-zÑñ0-9]+$";
}
