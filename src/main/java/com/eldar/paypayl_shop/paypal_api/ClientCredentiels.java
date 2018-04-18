package com.eldar.paypayl_shop.paypal_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientCredentiels {

    private String scope;
    private String nonce;
    private String access_token;
    private String app_id;
    private long expires_in;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "ClientCredentiels{" +
                "scope='" + scope + '\'' +
                ", nonce='" + nonce + '\'' +
                ", access_token='" + access_token + '\'' +
                ", app_id='" + app_id + '\'' +
                ", nonce='" + nonce + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
