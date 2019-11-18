package com.imooc.spring.ioc.class016;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class016")
@Lazy
public class TestConfiguration {

    @Bean("testBean2")
    //@Lazy
    public TestBean testBean(){
        return new TestBean();
    }
}
