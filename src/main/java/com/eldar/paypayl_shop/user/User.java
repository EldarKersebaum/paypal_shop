package com.eldar.paypayl_shop.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize
public class User {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private User mother;
    private User father;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public User getMother() {
        return mother;
    }

    public void setMother(User mother) {
        this.mother = mother;
    }

    public User getFather() {
        return father;
    }

    public void setFather(User father) {
        this.father = father;
    }

    public static User Father() {
        User father = new User();
        father.setFirstName("Helmut");
        father.setLastName("Schmidt");
        father.setBirthdate(new Date(1970, 1, 1));
        return father;
    }

    public static User Son() {
        User son = new User();
        son.setFirstName("Dieter");
        son.setLastName("Schmidt");
        son.setBirthdate(new Date(1999, 4, 7));
        son.setFather(User.Father());
        return son;
    }
}
