package com.imooc.spring.car;

public class Buick implements Car {
    public void start(){
        System.out.println("Buick.start");
    }
    public void left(){
        System.out.println("Buick.left");
    }
    public void right(){
        System.out.println("Buick.right");
    }
    public void stop(){
        System.out.println("Buick.stop");
    }
}
