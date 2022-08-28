package com.zhao.myspring.test;

import com.zhao.myspring.BeanDefinition;
import com.zhao.myspring.BeanFactory;
import com.zhao.myspring.test.bean.UserService;
import org.junit.Test;

/**
 * @author noblegasesgoo
 * @version 0.0.1
 * @date 2022/7/26 16:31
 * @description
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){

        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
