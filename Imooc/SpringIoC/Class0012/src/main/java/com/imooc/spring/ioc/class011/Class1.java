package com.imooc.spring.ioc.class011;

public class Class1 extends ParentClass{

    private String atttribute4;
    private String atttribute5;

    @Override
    public String toString() {
        return "Class1{" +
                "atttribute4='" + atttribute4 + '\'' +
                ", atttribute5='" + atttribute5 + '\'' +
                "atttribute1='" + getAtttribute1() + '\'' +
                "atttribute2='" + getAtttribute2() + '\'' +
                "atttribute3='" + getAtttribute3() + '\'' +
                '}';
    }

    public String getAtttribute4() {
        return atttribute4;
    }

    public void setAtttribute4(String atttribute4) {
        this.atttribute4 = atttribute4;
    }

    public String getAtttribute5() {
        return atttribute5;
    }

    public void setAtttribute5(String atttribute5) {
        this.atttribute5 = atttribute5;
    }
}
