package com.example.pc.ilearn.entity;

public class PeopleAll {
    private String llongtime;
    private String datetoday;
    private String id;
    private String username;
    private String saytext;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public PeopleAll() {


        this.llongtime = llongtime;
        this.datetoday = datetoday;
        this.id = id;
        this.saytext = saytext;
        this.username=username;
    }

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

    public String getSaytext() {
        return saytext;
    }
    public void setSaytext(String saytext) {
        this.saytext = saytext;
    }
    @Override
    public String toString() {
        return "PeopleAll{" +
                "llongtime='" + llongtime + '\'' +
                ", datetoday='" + datetoday + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", saytext='" + saytext + '\'' +
                '}';
    }
}