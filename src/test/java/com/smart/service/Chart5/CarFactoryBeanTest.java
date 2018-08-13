package com.smart.service.Chart5;


import com.smart.model.dirtype.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

@ContextConfiguration("classpath*:/spring/beans.xml")
public class CarFactoryBeanTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext factory = null;

    @Test
    public void testPropPathFactoryBean() {
        Car car5 = (Car) factory.getBean("car5");
        Car car6 = (Car) factory.getBean("car6");
        assertNotNull(car5);
        assertNotNull(car6);
        System.out.println(car5);
        System.out.println(car6);
    }
}
