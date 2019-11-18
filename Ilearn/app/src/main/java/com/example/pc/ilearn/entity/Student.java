package com.example.pc.ilearn.entity;

<<<<<<< HEAD

=======
/**
 * 保存学生信息的实体类
 * Created by he on 2016/10/1.
 */
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
public class Student {



    public int pwdresetFlag=0;
    private String username;
    private String password;
    private String password_checked;
    private String name;
    private String college;
    private String major;
<<<<<<< HEAD
    private String clas;//class
    private String rxny;//studentContent学习内容
    //private Integer sid;
    private String sid;//studentID学号
    private String id;
    private String enterTime;

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

=======
    private String clas;
    private String rxny;
    //private Integer sid;
    private String sid;
    private String id;
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Student( ) {

   // public Student( String enterTime,String id, String sid, String username, String password, String password_checked, String name, String college, String major) {

        this.enterTime=enterTime;
=======

    public Student(String id, String sid, String username, String password, String password_checked, String name, String college, String major) {

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
        this.sid=sid;
        this.id=id;
        this.username=username;
        this.password=password;
        this.password_checked=password_checked;
        this.name=name;
        this.college=college;
        this.major=major;
        this.clas=clas;
        this.rxny=rxny;
    }



   /* public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }*/
   public String getSid() {
       return sid;
   }

    public void setSid(String sid) {
        this.sid = sid;
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

    public String getPassword_checked() {
        return password_checked;
    }

    public void setPassword_checked(String password_checked) {
        this.password_checked = password_checked;
    }

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

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getRxny() {
        return rxny;
    }

    public void setRxny(String rxny) {
        this.rxny = rxny;
    }








}
