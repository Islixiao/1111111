package com.imooc.spring.ioc.class010;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class010Test {
    @Test
    public void test(){


        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("context已经被创建");
        Bean bean =context.getBean("bean",Bean.class);
        System.out.println("bean="+bean);

    }

}
