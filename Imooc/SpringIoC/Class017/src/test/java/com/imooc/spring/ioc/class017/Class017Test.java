package com.imooc.spring.ioc.class017;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Class017Test {



    @Test
    public void Test() {
        AbstractApplicationContext context = new
                AnnotationConfigApplicationContext(TestConfiguration.class);
        System.out.println("context.init");
        TestBean testBean=context.getBean("testBean",TestBean.class);
        System.out.println("testBean = " + testBean);
        context.close();



    }
}
