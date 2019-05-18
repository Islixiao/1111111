package com.imooc.spring.ioc.class006;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class006Test {
    @Test
    public void test(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring.xml");
       Bean bean= context.getBean("bean",Bean.class);

        AnotherBean anotherBean=context.getBean("anotherBean",AnotherBean.class);
        System.out.println("anotherBean="+anotherBean);
        AnotherBean anotherBean1=context.getBean("anotherBean",AnotherBean.class);
        System.out.println("anotherBean="+anotherBean1);
        System.out.println("-------------------");
        System.out.println("bean:"+bean);
        System.out.println("-------------------");
        System.out.println("bean.getStringList()="+bean.getStringList());
        System.out.println("bean.getStringSet()="+bean.getStringSet());
        System.out.println("bean.getStringMap()="+bean.getStringMap());
        System.out.println("bean.getAnotherBeanList()="+bean.getAnotherBeanList());
        System.out.println("bean.getAnotherBeanSet()="+bean.getAnotherBeanSet());
        System.out.println("bean.getAnotherBeanMap="+bean.getAnotherBeanMap());
        System.out.println("bean.getProperties()="+bean.getProperties());
        System.out.println("bean.getAnotherBean2()"+bean.getAnotherBean2());
    }

}
