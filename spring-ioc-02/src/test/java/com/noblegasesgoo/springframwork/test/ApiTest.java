package com.noblegasesgoo.springframwork.test;

import com.noblegaesgoo.springframework.beans.factory.config.BeanDefinition;
import com.noblegaesgoo.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 17:33
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: ApiTest
 * @Description:
 */


public class ApiTest {

    @Test
    public void test_BeanFactory(){

        // 创建默认bean工厂
        DefaultListableBeanFactory defaultBeanFactory = new DefaultListableBeanFactory();

        // 注册bean信息
        BeanDefinition beanDefinition = new BeanDefinition(MyService.class);
        defaultBeanFactory.registerBeanDefinition("myService", beanDefinition);

        // 第一次bean实例化对象获取，由于是第一次，所以我们的实例化容器中没有该bean，所以我们得实例化之后放入实例化容器中。
        MyService myService = (MyService) defaultBeanFactory.getBean("myService");
        myService.doTest();

        // 第二次bean实例化对象获取，由于该bean已经存在于实例化容器中了，直接拿就好了
        MyService myServiceSingleton =(MyService) defaultBeanFactory.getSingleton("myService");
        myServiceSingleton.doTest();
    }
}
