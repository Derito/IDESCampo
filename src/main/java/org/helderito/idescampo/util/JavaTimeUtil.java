package org.helderito.idescampo.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class JavaTimeUtil {

    private JavaTimeUtil() {}

    private  static final Locale LOCALE_PT = new Locale("pt", "PT");

    public static final DateTimeFormatter OFF_SET_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", LOCALE_PT);
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy", LOCALE_PT);


}

