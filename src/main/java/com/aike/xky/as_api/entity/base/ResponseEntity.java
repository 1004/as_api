package com.aike.xky.as_api.entity.base;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseEntity {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;

    }

    public ResponseEntity setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseEntity setData(Object data) {
        this.data = data;
        return this;
    }

    private ResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseEntity of(ResponseCode responseCode) {
        return new ResponseEntity(responseCode.getCode(), responseCode.getMsg());
    }

    public static ResponseEntity success(Object data) {
        return of(ResponseCode.RC_SUCCESS).setData(data);
    }

}
