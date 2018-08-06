package com.smart.context;

import com.smart.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car("红旗", "red", 200);
        return car;
    }

}
