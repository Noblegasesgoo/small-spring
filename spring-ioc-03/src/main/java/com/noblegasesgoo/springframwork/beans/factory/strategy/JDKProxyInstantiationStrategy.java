package com.noblegasesgoo.springframwork.beans.factory.strategy;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 15:09
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: JDKProxyInstantiationStrategy
 * @Description: JDK动态代理生成bean，之后来写
 */

public class JDKProxyInstantiationStrategy implements InstantiationStrategy{

    /**
     * bean实例化策略
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return 实例化之后的对象
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        return null;
    }
}
