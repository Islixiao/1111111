package com.example.pc.ilearn.entity;

public class PeopleAll {
    private String llongtime;
    private String datetoday;
<<<<<<< HEAD
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String username;
    private String id;
=======
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

>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    public String getLlongtime() {
        return llongtime;
    }

    public void setLlongtime(String llongtime) {
        this.llongtime = llongtime;
    }
<<<<<<< HEAD

=======
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
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

<<<<<<< HEAD
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
=======
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
>>>>>>> 868d64a130a7c62213b15cf0e8dcaef59832af25
    }
}