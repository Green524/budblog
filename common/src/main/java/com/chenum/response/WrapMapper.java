package com.chenum.response;

import com.chenum.exception.BusinessException;

public class WrapMapper {

    public static <T> Wrapper<T> ok(){
        return new Wrapper<>(200,"操作成功!",null);
    }

    public static <T> Wrapper<T> ok(T data){
        return new Wrapper<>(200,"操作成功!",data);
    }
    public static Wrapper<?> error(BusinessException be){
        return new Wrapper<>(be.code(),be.message(),be.data());
    }

    public static <T> Wrapper<T> error(T data){
        return new Wrapper<>(500,"操作失败!",data);
    }

    public static <T> Wrapper<T> error(String message){
        return new Wrapper<>(500,message,null);
    }

    public static <T> Wrapper<T> wrap(int code,String message,T data){
        return new Wrapper<>(code,message,data);
    }
}
