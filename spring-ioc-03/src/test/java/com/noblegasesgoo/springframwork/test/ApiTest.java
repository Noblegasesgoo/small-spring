package com.noblegasesgoo.springframwork.test;

import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;
import com.noblegasesgoo.springframwork.beans.factory.impl.DefaultListableBeanFactory;
import com.noblegasesgoo.springframwork.beans.factory.strategy.SimpleInstantiationStrategy;
import org.junit.Test;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 15:50
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: ApiTest
 * @Description:
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){

        // 创建默认bean工厂
        DefaultListableBeanFactory defaultBeanFactory = new DefaultListableBeanFactory();

        // 设置初始化策略
        defaultBeanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());

        // 注册bean信息
        BeanDefinition beanDefinition = new BeanDefinition(MyService.class);
        defaultBeanFactory.registerBeanDefinition("myService", beanDefinition);

        // 第一次bean实例化对象获取，由于是第一次，所以我们的实例化容器中没有该bean，所以我们得实例化之后放入实例化容器中。
        MyService myService = (MyService) defaultBeanFactory.getBean("myService", 1);
        myService.doTest();

        // 第二次bean实例化对象获取，由于该bean已经存在于实例化容器中了，直接拿就好了
        MyService myServiceSingleton =(MyService) defaultBeanFactory.getSingleton("myService");
        myServiceSingleton.doTest();
    }
}
