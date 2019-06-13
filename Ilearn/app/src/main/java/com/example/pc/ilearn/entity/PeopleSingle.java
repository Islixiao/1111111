package com.example.pc.ilearn.entity;

public class PeopleSingle {
    private String llongtime;
    private String datetoday;
    private String id;
    private String saytext;
    public PeopleSingle() {
    //public PeopleSingle(String llongtime,String datetoday,String id,String saytext) {
        this.llongtime = llongtime;
        this.datetoday = datetoday;
        this.id = id;
        this.saytext = saytext;
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
        return "PeopleSingle{" +
                "llongtime='" + llongtime + '\'' +
                ", datetoday='" + datetoday + '\'' +
                ", id='" + id + '\'' +
                ", saytext='" + saytext + '\'' +
                '}';
    }
}