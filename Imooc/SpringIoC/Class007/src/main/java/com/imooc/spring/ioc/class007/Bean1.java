package com.imooc.spring.ioc.class007;

public  abstract class Bean1 {


//    private Bean2 bean2;
//
//    public Bean2 getBean2() {
//        return bean2;
//    }
//
//    public void setBean2(Bean2 bean2) {
//        this.bean2 = bean2;
//    }
// public void printBean2(){
//        System.out.printf("bean2="+bean2);
//    }
    protected abstract  Bean2 createbean2();
    public void printBean2(){
        System.out.println("bean2="+createbean2());
    }
//    @Override
//    public String toString() {
//        return "Bean1{" +
//                "bean2=" + bean2 +
//                '}';
//    }

}
