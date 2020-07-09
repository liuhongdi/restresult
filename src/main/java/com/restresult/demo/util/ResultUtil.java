package com.restresult.demo.util;
import com.restresult.demo.constant.ResponseCode;

import java.io.Serializable;


/**
 * @desc: API 返回结果
 * @author: liuhongdi
 * @date: 2020-07-01 11:53
 * return :
 * 0:success
 * not 0: failed
 */
public class ResultUtil implements Serializable {

    private static final long serialVersionUID = 7498483649536881777L;
    private Integer code;
    private String msg;
    private Object data;

    public ResultUtil() {
    }

    public ResultUtil(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResultUtil success(Object data) {
        return new ResultUtil(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static ResultUtil error(ResponseCode code) {
        return new ResultUtil(code.getCode(), code.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}