package com.eldar.paypayl_shop.user;

import com.eldar.paypayl_shop.paypal_api.UserInformation;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class User {
    private UserInformation userInformation;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public User(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}
