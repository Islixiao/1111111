package com.imooc.spring.ioc.class017;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class017")
public class TestConfiguration {

    @Bean(initMethod = "onInit1",destroyMethod = "onDestory1")
    public TestBean testBean(){
        return new TestBean();
    }


}
