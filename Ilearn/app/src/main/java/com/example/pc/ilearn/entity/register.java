package com.example.pc.ilearn.entity;

public class register {
    private String username;
    private  int password;
    private  int password_checked;
    public register(String username, int password, int password_checked) {

        this.password = password;
        this.username = username;
        this.password_checked = password_checked;
    }
    //获取用户名
    public String getUsename() {
        return username;
    }
    //输入用户名
    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setPassword_checked(int password_checked) {
        this.password_checked = password_checked;
    }

    public int getPassword_checked() {
        return password_checked;
    }
}
