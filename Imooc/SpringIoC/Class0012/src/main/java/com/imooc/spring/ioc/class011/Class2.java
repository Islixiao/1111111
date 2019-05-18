package com.imooc.spring.ioc.class011;

public class Class2 extends ParentClass{

    private String atttribute6;
    private String atttribute7;

    @Override
    public String toString() {
        return "Class2{" +
                "atttribute6='" + atttribute6 + '\'' +
                ", atttribute7='" + atttribute7 + '\'' +
                "atttribute1='" + getAtttribute1() + '\'' +
                "atttribute2='" + getAtttribute2() + '\'' +
                "atttribute3='" + getAtttribute3() + '\'' +
                '}';
    }

    public String getAtttribute6() {
        return atttribute6;
    }

    public void setAtttribute6(String atttribute6) {
        this.atttribute6 = atttribute6;
    }

    public String getAtttribute7() {
        return atttribute7;
    }

    public void setAtttribute7(String atttribute7) {
        this.atttribute7 = atttribute7;
    }
}
