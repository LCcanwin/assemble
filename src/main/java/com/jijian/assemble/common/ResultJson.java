package com.jijian.assemble.common;

import org.springframework.http.HttpStatus;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/14 21:37
 */
public class ResultJson<T> {
    private int code;
    private String msg;
    private T data;

    public ResultJson(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultJson(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResultJson<E> getReturnJson(E data){
        return new ResultJson<E>(HttpStatus.OK.value(), HttpStatus.OK.name(), data);
    }

    public static <E> ResultJson<E> getReturnJson(int code, String msg, E data){
        return new ResultJson<E>(code, msg, data);
    }

    public static <E> ResultJson<E> getReturnJson(String msg, E data){
        return new ResultJson<E>(HttpStatus.OK.value(), msg, data);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
