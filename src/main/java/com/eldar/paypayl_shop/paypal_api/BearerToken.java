package com.eldar.paypayl_shop.paypal_api;

/*
{
    "scope": "https://uri.paypal.com/services/disputes/read-seller https://uri.paypal.com/services/subscriptions https://api.paypal.com/v1/payments/.* https://uri.paypal.com/services/disputes/read-buyer https://api.paypal.com/v1/vault/credit-card https://uri.paypal.com/services/applications/webhooks openid https://uri.paypal.com/payments/payouts https://uri.paypal.com/services/disputes/update-seller https://api.paypal.com/v1/vault/credit-card/.*",
    "nonce": "2018-04-18T00:11:48ZBcW-g8dmY7yjjEAT5P-Fu99RC1JC68pawwoYSM58H8E",
    "access_token": "A21AAG_LAQ0qgcAdgIBpFDCxB1F4yEz0YpSz1ldVTaPmJLSQ80_itzwe40XyQIm3sLBU721PXg-5SykbiZyKZsPs-F91cuXrg",
    "token_type": "Bearer",
    "app_id": "APP-80W284485P519543T",
    "expires_in": 32400
}
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BearerToken {

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
        return "BearerToken{" +
                "scope='" + scope + '\'' +
                ", nonce=" + nonce +
                ", access_token=" + access_token +
                ", app_id=" + app_id +
                ", nonce=" + nonce +
                ", expires_in=" + expires_in +
                '}';
    }
}
