package com.restresult.demo.exception;

import com.restresult.demo.constant.ResponseCode;

/**
 * 业务逻辑异常
 */
public class BusinessException extends RuntimeException{

    private ResponseCode rcode;
    //private Throwable e;

    public BusinessException(ResponseCode rcode) {
        this.rcode = rcode;
    }


    public ResponseCode getResponseCode() {
        return this.rcode;
    }
    public void setResponseCode(ResponseCode rcode) {
        this.rcode = rcode;
    }

}
