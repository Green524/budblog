package com.chenum.util;

import java.util.Objects;

public class FieldUtils {

    public static final String SETTER = "set";

    public static final String GETTER = "get";
    public static String field(String methodName){
        if (Objects.isNull(methodName)){
            throw new RuntimeException("arg is null");
        }
        String uppercaseLetter = methodName.substring(3,4).toLowerCase();
        return uppercaseLetter + methodName.substring(4);
    }

    public static String setter(String field){
        String uppercaseLetter = field.substring(0,1).toUpperCase();
        String suffixLetter = field.substring(1);
        return SETTER + uppercaseLetter + suffixLetter;
    }

    public static String getter(String field){
        String uppercaseLetter = field.substring(0,1).toUpperCase();
        String suffixLetter = field.substring(1);
        return GETTER + uppercaseLetter + suffixLetter;
    }
}
