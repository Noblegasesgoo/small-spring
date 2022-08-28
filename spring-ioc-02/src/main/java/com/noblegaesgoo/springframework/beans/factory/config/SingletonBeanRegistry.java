package com.noblegaesgoo.springframework.beans.factory.config;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 11:19
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: SingletonBeanRegistry
 * @Description: 获取单例对象的能力接口
 */

public interface SingletonBeanRegistry {

    /**
     * 获取对应单例bean名称的对应实例化bean对象
     * @param singletonBeanName
     * @Return 对应单例bean名称的对应实例化bean对象
     */
    Object getSingleton(String singletonBeanName);
}
