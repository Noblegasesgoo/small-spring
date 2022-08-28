package com.noblegaesgoo.springframework.beans.factory.support;

import com.noblegaesgoo.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 16:31
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: DefaultsSingletonBeanFactory
 * @Description: 默认单例对象的容器工厂
 */
public class DefaultSingletonBeanFactory implements SingletonBeanRegistry {

    /**
     * 实例化过后的单例bean容器
     */
    private final Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取对应单例bean名称的对应实例化bean对象
     * @param singletonBeanName
     * @Return 对应单例bean名称的对应实例化bean对象
     */
    @Override
    public Object getSingleton(String singletonBeanName) {
        return singletonObjects.get(singletonBeanName);
    }

    /**
     * 添加对应bean实例对象到实例对象容器中
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
