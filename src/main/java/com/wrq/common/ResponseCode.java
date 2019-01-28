package com.wrq.common;

/**
 * Created by wangqian on 2019/1/28.
 *
 * 1: 属性尽量用final修改
 * 2: 构造函数不能用public修饰/protected
 * 3: 不能继承
 * 4: setter已经函无意思
 *
 */
public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),
    ERROR(400, "ERROR"),
    SERVER_ERROR(500, "Server Error"),
    NEED_LOGIN(100, "NEED_LOGIN"),
    ERROR_LOGIN(401, "你输入的账号和密码有误!!"),
    ERROR_CODE_LOGIN(402, "你输入的验证有误!!"),
    SESSION_FAIIL(101, "SESSION IS CLOSED"),
    ILLEGAL_ARGUMENT(202, "ILLEGAL_ARGUMENT");

    private  final int code;
    private  final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}