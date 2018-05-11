package com.sjto.enums;

/**
 * @ClassName AuthState
 * @Description 认证状态枚举
 * @Author wangsai
 * @Date 2018/5/11 15:51
 **/
public enum  AuthState {
    NO_AUTHED(0, "未认证"),
    IN_AUTHING(1, "认证中"),
    AUTHED(2, "已认证"),
    FALSE_AUTH(3 , "认证失败");

    private Integer code;
    private String message;

    AuthState(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
