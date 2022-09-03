package com.noblegasesgoo.springframwork.beans.factory.impl;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;
import com.noblegasesgoo.springframwork.beans.factory.support.AbstractAutowireCapableBeanFactory;
import com.noblegasesgoo.springframwork.beans.factory.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:07
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: DefaultListableBeanFactory
 * @Description: 核心实现类，默认具体Bean工厂实现类
 */

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * bean定义信息容器
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据beanDefinitionName获取对应bean的BeanDefinition信息，模板方法
     * @param beanDefinitionName
     * @return 对应beanDefinitionName的bean注册信息
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanDefinitionName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanDefinitionName);
        if (Objects.isNull(beanDefinition)) {
            throw new BeansException("No bean definition which was bean named '" + beanDefinitionName + "' is defined");
        }
        return beanDefinition;
    }

    /**
     * 注册beanName对应的BeanDefinition到对应的BeanDefinition容器中去
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
