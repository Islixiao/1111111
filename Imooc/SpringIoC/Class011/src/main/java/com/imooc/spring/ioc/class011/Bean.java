package com.imooc.spring.ioc.class011;

public class Bean {

    public void onInit(){
        System.out.println("Bean.Init");
    }
    public void onDestroy(){
        System.out.println("Bean.Destroy");
    }
}
