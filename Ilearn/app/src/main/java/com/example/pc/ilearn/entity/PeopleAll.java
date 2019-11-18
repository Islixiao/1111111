package com.example.pc.ilearn.entity;

public class PeopleAll {
    private String llongtime;
    private String datetoday;
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String username;
    private String id;
    public String getLlongtime() {
        return llongtime;
    }

    public void setLlongtime(String llongtime) {
        this.llongtime = llongtime;
    }

    public String getDatetoday() {
        return datetoday;
    }

    public void setDatetoday(String datetoday) {
        this.datetoday = datetoday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaytext() {
        return saytext;
    }

    public void setSaytext(String saytext) {
        this.saytext = saytext;
    }

    private String saytext;
    public PeopleAll() {

//    public PeopleAll(String llongtime, String datetoday, String id, String username, String saytext) {
        this.llongtime = llongtime;
        this.datetoday = datetoday;
        this.pid = pid;
        this.username = username;
        this.saytext = saytext;
    }
}