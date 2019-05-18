package com.imooc.spring.ioc.class013;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Bean1 bean1(){
        return new Bean1();

    }



}
