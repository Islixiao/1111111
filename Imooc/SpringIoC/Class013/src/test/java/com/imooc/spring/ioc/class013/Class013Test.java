package com.imooc.spring.ioc.class013;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class013Test {

    @Test
    public void Test(){
        //ApplicationContext context=new AnnotationConfigApplicationContext(MyConfiguration.class);
        ApplicationContext context=new
                AnnotationConfigApplicationContext(MyConfiguration1.class);

        Bean1 bean1 =context.getBean("bean2",Bean1.class);
        System.out.println("bean1="+bean1);
    }
}
