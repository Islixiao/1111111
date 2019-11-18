package com.imooc.spring.ioc.class016;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("testBean1")
@Lazy
public class TestBean {
    public TestBean() {
        System.out.println(" TestBean.init" );
    }
}
