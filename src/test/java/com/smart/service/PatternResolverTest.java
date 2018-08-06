package com.smart.service;

import com.smart.model.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

/**
 * 测试环境下用 classpath:匹配不到对应的文件
 * 是因为这个PathMatchingResourcePatternResolver 该类会在当前的class文件下查找
 * 而编译后的class文件目录下面没有资源文件，
 * 但是使用classpaht*:则会匹配所有对应目录 所以能找到文件
 */
// @ContextConfiguration("classpath*:/com/smart")
public class PatternResolverTest {
    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String path = "classpath:com/smart/**/beans.xml";
        Resource[] resources = resolver.getResources(path);
        assertNotNull(resources);
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }

    }

    @Test
    public void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");
        System.out.println(resources.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resources);

        System.out.println("init beanfactory");
        Car car = factory.getBean("car",Car.class);
        System.out.println("car is ready for use");
        car.introduce();
    }
}
