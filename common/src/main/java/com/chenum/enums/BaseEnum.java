package com.chenum.enums;

public enum BaseEnum {
    OK(200,"操作成功!"),
    ERROR(500,"操作失败!"),

    PARAMS_ERROR(5001,"参数异常"),

    INERT_ERROR(6001,"Insert异常"),

    DELETE_ERROR(6002,"Delete异常"),

    SELECT_ERROR(6003,"Select异常"),

    UPDATE_ERROR(6004,"Update异常"),
    ;

    private int code;
    private String message;
    private Object data;

    BaseEnum(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    BaseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public BaseEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String message() {
        return message;
    }

    public BaseEnum setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object data() {
        return data;
    }

    public BaseEnum setData(Object data) {
        this.data = data;
        return this;
    }
}
