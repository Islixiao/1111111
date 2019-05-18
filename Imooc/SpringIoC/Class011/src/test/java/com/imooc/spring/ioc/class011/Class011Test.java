package com.imooc.spring.ioc.class011;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class011Test {
        @Test
        public void test(){
            AbstractApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
            Bean bean=context.getBean("bean",Bean.class);
            System.out.println("bean="+bean);
            Bean1 bean1=context.getBean("bean1",Bean1.class);
            context.close();

    }

}


