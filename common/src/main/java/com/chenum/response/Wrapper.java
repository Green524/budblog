package com.chenum.response;

public record Wrapper<T>(int code, String message, T data){

    public boolean success(){
        return code == 200;
    }

    public boolean error(){
        return !success();
    }
}
