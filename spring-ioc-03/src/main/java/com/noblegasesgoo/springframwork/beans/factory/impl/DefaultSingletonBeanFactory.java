package com.noblegasesgoo.springframwork.beans.factory.impl;

import com.noblegasesgoo.springframwork.beans.factory.registry.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:06
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: DefaultSingletonBeanFactory
 * @Description: 默认单例实例对象工厂
 */

public class DefaultSingletonBeanFactory implements SingletonBeanRegistry {


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
     * @param singletonBeanName
     * @param singletonObject
     */
    protected void addSingleton(String singletonBeanName, Object singletonObject) {
        singletonObjects.put(singletonBeanName, singletonObject);
    }
}
