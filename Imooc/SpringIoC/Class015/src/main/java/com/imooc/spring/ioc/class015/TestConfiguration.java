package com.imooc.spring.ioc.class015;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.imooc.spring.ioc.class015")
public class TestConfiguration {


/*    @Bean(name = "testBean1")
    @Scope("prototype")
    public TestBean testBean(){
        return new TestBean();
    }*/

}
