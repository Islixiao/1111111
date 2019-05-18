package com.imooc.spring.ioc.class007;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class007Test {
    @Test
    public void test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
//        Bean2 bean2_1=context.getBean("bean2",Bean2.class);
//        System.out.println("bean2_1="+bean2_1);
//        Bean2 bean2_2=context.getBean("bean2",Bean2.class);
//        System.out.println("bean2_2="+bean2_2);
        Bean1 bean1=context.getBean("bean1",Bean1.class);
        System.out.println("bean1="+bean1);
        bean1.printBean2();
        bean1.printBean2();
        bean1.printBean2();
        bean1.printBean2();

    }


}
