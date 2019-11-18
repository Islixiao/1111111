package com.imooc.spring.ioc.class011;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean1 implements InitializingBean,DisposableBean {
    public void onInit(){
        System.out.println("Bean1.Init1");
    }
    public void onDestroy(){
        System.out.println("Bean1.Destroy1");
    }

    public void destroy() throws Exception {
        System.out.println("Bean1.destroy12");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean1.afterPropertiesSet");
    }
}
