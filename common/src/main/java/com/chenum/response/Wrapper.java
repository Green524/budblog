package com.chenum.response;

public record Wrapper<T>(int code,String message,T data){}
