package com.imooc.spring.ioc.class014;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Class014Test {

    @Test
    public void Test(){
        //ApplicationContext context=new AnnotationConfigApplicationContext(MyConfiguration.class);
        ApplicationContext context=new
                AnnotationConfigApplicationContext(MyConfigruation.class);

        MyBean myBean =context.getBean("myBean",MyBean.class);
        System.out.println("bean1="+myBean);
        
        for (String s : myBean.getStringList()) {
            System.out.println("s = " + s);
        }

        for (Map.Entry<String, Integer> entry : myBean.getIntegerMap().entrySet()) {
            System.out.println("entry = " + entry);
        }
        AnotherBean anotherBean=myBean.getContext().getBean("anotherBean",AnotherBean.class);
        System.out.println("anotherBean = " + anotherBean);

    }
}
