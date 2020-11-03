package com.translate.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String stripAccents(String input) {
        String str = StringUtils.trim(input).toLowerCase();

        str = StringUtils.stripAccents(str);
        str = str.replaceAll("đ", "d");
        str = str.replaceAll("[^\\p{Alpha}\\p{Digit}]+", " ");

        return str;
    }

    public static String stripAccents(String input, CharSequence character) {
        String str = StringUtils.trim(input).toLowerCase();

        str = StringUtils.stripAccents(str);
        str = str.replaceAll("đ", "d");
        str = str.replaceAll("[^\\p{Alpha}\\p{Digit}]+", character.toString());
        str = str.replaceAll("-$", "");
        str = str.replaceAll("^-", "");
        return str;
    }
}
