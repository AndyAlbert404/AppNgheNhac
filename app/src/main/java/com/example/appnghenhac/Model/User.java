package com.example.appnghenhac.Model;

import java.io.Serializable;

public class User implements Serializable{
    private String Username;
    private String Password;
    private String Email;
    private String Phonenumber;
    private int sex;

    public User(String username, String password, String email, String phonenumber, int sex, String avatar) {
        this.Username = username;
        this.Password = password;
        this.Email = email;
        this.Phonenumber = phonenumber;
        this.sex = sex;
        this.avatar = avatar;
    }

    public User() {

    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public int getSex() {
        return sex;
    }

    public String getAvatar() {
        return avatar;
    }


}
