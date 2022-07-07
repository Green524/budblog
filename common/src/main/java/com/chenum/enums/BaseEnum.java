package com.chenum.enums;

public enum BaseEnum {
    OK(200,"操作成功!",null),
    ERROR(500,"操作失败!",null)
    ;
    private int code;
    private String message;
    private Object data;

    BaseEnum(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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
