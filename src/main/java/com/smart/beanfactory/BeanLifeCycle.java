package com.smart.beanfactory;

import com.smart.context.MyBeanPostProcessor;
import com.smart.context.MyInstantiationAwareBeanPostProcessor;
import com.smart.model.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory() {
        //1 装载配置
        Resource res = new ClassPathResource("/spring/beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
        reader.loadBeanDefinitions(res);

        //2 注册 MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //3 注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //4 第一次从容器中获取car 将触发容器实例化car 引起bean生命周期的调用
        System.out.println("--------配置文件中的car是红色 速度是300----------");
        Car car = (Car) bf.getBean("car");
        car.introduce();

        car.setMaxSpeed(300);
        car.setColor("红色");
        //5 第二次从容器中获取car 直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");
        car2.introduce();

        //6 两者相等
        System.out.println("car1 == car2:" + (car == car2));

        //7关闭容器
        ((DefaultListableBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
