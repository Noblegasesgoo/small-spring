package com.noblegasesgoo.springframwork.beans.factory.strategy;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:49
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: SimpleInstantiationStrategy
 * @Description: bean实例化简单策略
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {

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

        Class beanClass = beanDefinition.getBeanClass();

        try {
            if (Objects.isNull(beanClass)) {
                // 如果没有传入构造函数，那么就选用无参构造
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                // 如果传入指定构造函数，就选用当前构造函数
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
