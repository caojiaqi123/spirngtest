package com.smart.controller;

import com.smart.model.Car;
import com.smart.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Index {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/index.html")
    public ModelAndView login(HttpServletRequest request) {
        Car car = loginService.getCar(); 
        return new ModelAndView("login", "car", car);
    }

    @RequestMapping(value = "/index2.html")
    public void index2(HttpServletRequest request) {
        Car car = loginService.getCar();
         car.introduce();

    }
}
