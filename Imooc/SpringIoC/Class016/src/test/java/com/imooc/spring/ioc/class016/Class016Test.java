package com.imooc.spring.ioc.class016;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class016Test {


    @Test
    public void Test() {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(TestConfiguration.class);
        System.out.println("context init");
        TestBean testBean1=context.getBean("testBean1",TestBean.class);
        System.out.println("testBean1 = " + testBean1);
        TestBean testBean2=context.getBean("testBean2",TestBean.class);
        System.out.println("testBean2 = " + testBean2);
    }
}
