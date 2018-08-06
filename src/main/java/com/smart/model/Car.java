package com.smart.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + "maxspeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void myInit() {
         maxSpeed = 240;
        System.out.println("初始化car 将速度设置为240");
    }

    private void myDestory() {
        System.out.println("销毁");
    }

    //调用BeanFactoryAware接口
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.afterPropertiesSet()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }
}
