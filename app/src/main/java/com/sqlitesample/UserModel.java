package com.sqlitesample;

/**
 * Created by madhu on 05-Nov-17.
 */

public class UserModel {

    private int userId;
    private String user_first_name;
    private String user_last_name;
    private String user_phone_number;
    private String user_pass;
    private String user_email;


    public UserModel() {
    }

    public UserModel(int userId, String user_first_name, String user_last_name, String user_phone_number, String user_pass, String user_email) {
        this.userId = userId;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_phone_number = user_phone_number;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

    public UserModel(String user_first_name, String user_last_name, String user_phone_number, String user_pass, String user_email) {
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_phone_number = user_phone_number;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
