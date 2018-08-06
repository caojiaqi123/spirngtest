package com.smart.context;

import com.smart.model.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Instantiation 实例化
 * aware 察觉到
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    //实例化bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.equals(Car.class)) {
            System.out.println("InstationtationAware BeanPostProcess.postProcessBeforeInstantiation()--by class name");
        }

        if ("car".equals(beanName)){
            System.out.println("InstationtationAware BeanPostProcess.postProcessBeforeInstantiation()--by bean name");
        }
        return null;
    }

    //实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("InstationtationAware BeanPostProcess.postProcessAfterInstantiation()");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("Instantiation AwareBeanPostProcessor.postProcessPropertyValues ");
        }
       // return super.postProcessPropertyValues(pvs, pds, bean, beanName);
        return pvs;
    }
}
