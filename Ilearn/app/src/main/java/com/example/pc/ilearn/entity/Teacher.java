package com.example.pc.ilearn.entity;

public class Teacher {

    private String password;
    private String name;
    private String college;
    private String major;
    private String tid;//teacherID教职工号
    private Integer id;
    private String username;
    //public Teacher(String name, String college, String major, Integer tid, Integer id, String username, String password) {
    public Teacher() {

        this.name = name;
        this.college = college;
        this.major = major;
        this.tid = tid;
        this.id = id;
        this.username = username;
        this.password = password;
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

   /* public String getPassword_checked() {
        return password_checked;
    }

    public void setPassword_checked(String password_checked) {
        this.password_checked = password_checked;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
