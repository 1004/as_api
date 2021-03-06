package com.aike.xky.as_api.entity.base;

public enum ResponseCode {
    RC_SUCCESS(0, "success"),
    RC_MUST_LOGIN(-1, "用户未登录"),

    RC_ACCOUNT_INVALID(5001, "未找到账号"),
    RC_PWD_INVALID(5002, "密码错误"),
    RC_USER_FORBIND(5003, "用户禁用"),

    RC_CONFIG_INVALID(8001,"配置信息参数不符合要求"),


    RC_GOODS_CATEGROY_REPEAT(6001,"商品添加重复")

    ;
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
