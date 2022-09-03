package com.noblegasesgoo.springframwork.beans.factory.registry;

import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:07
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeanDefinitionRegistry
 * @Description: bean信息注册能力提供接口
 */

public interface BeanDefinitionRegistry {

    /**
     * 注册beanName对应的BeanDefinition到对应的BeanDefinition容器中去
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
