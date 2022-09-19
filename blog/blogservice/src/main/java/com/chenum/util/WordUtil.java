package com.chenum.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtil {
    private static final Pattern p = Pattern.compile("[\\u4e00-\\u9fa5[a-zA-Z][0-9]]");

    public static long count(String text) {
        long count = 0;

        Matcher m = p.matcher(text);
        while (m.find()) {
            count++;
        }
        return count;
    }
}
