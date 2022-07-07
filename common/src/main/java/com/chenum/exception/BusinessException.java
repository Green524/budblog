package com.chenum.exception;

import com.chenum.enums.BaseEnum;

public class BusinessException extends RuntimeException{

    private int code;

    private String message;

    private Object data;

    public BusinessException(BaseEnum baseEnum){
        super(baseEnum.message());
        this.code = baseEnum.code();
        this.message = baseEnum.message();
        this.data = baseEnum.data();
    }

    public BusinessException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int code() {
        return code;
    }

    public BusinessException setCode(int code) {
        this.code = code;
        return this;
    }

    public String message() {
        return message;
    }

    public BusinessException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object data() {
        return data;
    }

    public BusinessException setData(Object data) {
        this.data = data;
        return this;
    }
}
