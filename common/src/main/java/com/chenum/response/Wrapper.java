package com.chenum.response;

import java.io.Serializable;

public record Wrapper<T> (int code, String message, T data) implements Serializable{

    public boolean success(){
        return code == 200;
    }

    public boolean error(){
        return !success();
    }
}
