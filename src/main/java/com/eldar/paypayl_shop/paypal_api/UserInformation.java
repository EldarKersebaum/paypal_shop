package com.eldar.paypayl_shop.paypal_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInformation {

    private String user_id;
    private String name;
    private String middle_name;
    private String email;
    private boolean verified;
    private String birthday;
    private String locale;
    private String language;
    private String birthdate;
    private boolean email_verified;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
    }

    @Override
    public String toString() {
        return "BearerToken{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", email='" + email + '\'' +
                ", verified='" + verified + '\'' +
                ", birthday='" + birthday + '\'' +
                ", locale='" + locale + '\'' +
                ", language='" + language + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email_verified='" + email_verified + '\'' +
                '}';
    }
}
