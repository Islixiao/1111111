package com.imooc.spring.ioc.class014;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(value = "com.imooc.spring.ioc.class014")
public class MyConfigruation {

/*
    @Bean(name = "stringList")
    public List<String> stringList(){
        List<String> list=new ArrayList<String>();
        list.add("111");
        list.add("222");
        return  list;
    }*/

    @Bean
    public Map<String,Integer> integerMap(){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("aaa",111);
        map.put("bbb",222);
        return map;
    }
    @Bean
    @Order(50)
    public String string1(){
        return "333";
    }
    @Bean
    @Order(10)
    public String string2(){
        return "444";
    }
}
