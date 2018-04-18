package com.eldar.paypayl_shop.paypal_api;

public class AuthCode {
    private String code;
    private String scope;

    public AuthCode(String code, String scope) {
        this.code = code;
        this.scope = scope;
    }

    public String getCode() {
        return code;
    }

    public String getScope() {
        return scope;
    }
}
