package com.smart.context;

import com.smart.model.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
          //  if (car.getColor() != null) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization 设置颜色为黑色");
                car.setColor("黑色");
            //}
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
         //   if (car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization 将速度设置为200");
                car.setMaxSpeed(200);
          //  }
        }
        return bean;
    }
}
