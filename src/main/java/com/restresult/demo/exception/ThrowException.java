package com.restresult.demo.exception;

import com.restresult.demo.constant.ResponseCode;

public class ThrowException extends RuntimeException{

    private Throwable e;

    public ThrowException(Throwable e) {
        this.e = e;
    }

    public String getMsg() {
        return e.toString();
    }
}