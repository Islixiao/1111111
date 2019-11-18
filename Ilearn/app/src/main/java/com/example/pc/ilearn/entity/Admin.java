package com.example.pc.ilearn.entity;

public class Admin {
    private String username;
    private String password;
    private Integer id;



    public Admin(Integer id, String username, String password) {
        this.id=id;
        this.password = password;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}