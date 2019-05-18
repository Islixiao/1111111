package com.imooc.spring.human;

import com.imooc.spring.car.Car;

public abstract class HumenWithCar implements Humen {
    public Car car;//提到属性域里
    public HumenWithCar(Car car){
        this.car=car;
    }
    public abstract  void  goHome();

}
