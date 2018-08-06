package com.smart.service.Imp;

import com.smart.dao.LoginDao;
import com.smart.model.Car;
import com.smart.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public String loginIn() {
        return loginDao.loginIn();
    }

    public Car getCar() {
        // Car car = new Car();
        // car.setColor("red");
        // car.setBrand("benz");
        // car.setMaxSpeed(1000);
        Car car = getCar2();
        return car;
    }

    public Car getCar2() {
        Car car = null;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class clazz = loader.loadClass("com.smart.model.Car");

            Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
            car = (Car) cons.newInstance();

            Method setBrand = clazz.getMethod("setBrand", String.class);
            setBrand.invoke(car, "红旗");
        } catch (Exception e) {
        }
        return car;
    }
}
