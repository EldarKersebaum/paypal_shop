package com.eldar.paypayl_shop.user;

import com.eldar.paypayl_shop.paypal_api.AuthCode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize
public class User {
    private String firstName;
    private String lastName;
    private String emailAdress;
    private Date birthdate;
    private AuthCode authCode;

    public User(AuthCode authCode) {
        this.authCode = authCode;
    }

    public void getUserInformation(){

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public AuthCode getAuthCode() {
        return authCode;
    }
}
