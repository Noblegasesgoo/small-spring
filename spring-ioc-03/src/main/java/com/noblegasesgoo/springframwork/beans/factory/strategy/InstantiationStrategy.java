package com.noblegasesgoo.springframwork.beans.factory.strategy;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:48
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: InstantiationStrategy
 * @Description: bean实例化策略能力提供接口，策略模式
 */

public interface InstantiationStrategy {

    /**
     * bean实例化策略
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return 实例化之后的对象
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
