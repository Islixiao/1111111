package com.imooc.spring.ioc.class014;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MyBean {

    private AnotherBean anotherBean1;
    private AnotherBean anotherBean2;

    @Autowired
    private AnotherBean anotherBean3;

    private List<String> stringList;
    private Map<String,Integer> integerMap;
    private String string;
    private ApplicationContext context;


    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    public ApplicationContext getContext() {
        return context;
    }
    @Value("555")
    public void setString(String string) {
        this.string = string;
    }
    public String getString() {
        return string;
    }
    @Autowired
    public void setIntegerMap(Map<String, Integer> integerMap) {
        this.integerMap = integerMap;
    }

    public Map<String, Integer> getIntegerMap() {
        return integerMap;
    }
    @Autowired
//    @Qualifier("stringList")
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }


    public List<String> getStringList() {
        return stringList;
    }


    @Autowired
    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    @Autowired
    public MyBean(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "anotherBean1=" + anotherBean1 +
                ", anotherBean2=" + anotherBean2 +
                ", anotherBean3=" + anotherBean3+
                ", string=" + string+
        '}';
    }
}
