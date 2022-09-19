package com.chenum.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtil {
    private static final Pattern PATTERN_COUNT = Pattern.compile("[\\u4e00-\\u9fa5[a-zA-Z][0-9]]");

    private static final Pattern PATTERN_URL = Pattern.compile("(https?:[^:<>\"]*\\/)([^:<>\"]*)(\\.((png!thumbnail)|(png)|(jpg)|(webp)))");

    private static final float AVERAGE_RAED_TIME = 275;

    public static long count(String text) {
        long count = 0;
        Matcher m = PATTERN_COUNT.matcher(text);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static float readTime(long count,String text){
        float time = (count / AVERAGE_RAED_TIME);
        Matcher m = PATTERN_URL.matcher(text);
        while (m.find()){
            time += 12;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(readTime(76L,"# 维护模式\\n维护模式主要拥有三个接口。\\nps:均不支持json，如果使用application/json 需要将long类型转为包装类，将对象包装为对象，一定程度影响效率")));
    }
}
