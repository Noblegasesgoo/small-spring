package com.noblegaesgoo.springframework.beans.factory.support;

import com.noblegaesgoo.springframework.beans.BeansException;
import com.noblegaesgoo.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 16:30
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: DefaultListableBeanFactory
 * @Description: 核心实现类，默认Bean工厂列表
 */

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * bean注册信息容器
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据beanDefinitionName获取对应bean的BeanDefinition信息
     * @param beanDefinitionName
     * @return 对应beanDefinitionName的bean注册信息
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanDefinitionName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanDefinitionName);
        if (beanDefinition == null) {
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
