package com.smart.context;

import com.smart.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        try {

            ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
            Car car = context.getBean("car",Car.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // WebApplicationContextUtils.getWebApplicationContext()
    }
}
