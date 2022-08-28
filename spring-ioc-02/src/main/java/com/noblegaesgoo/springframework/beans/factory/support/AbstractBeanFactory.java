package com.noblegaesgoo.springframework.beans.factory.support;

import com.noblegaesgoo.springframework.beans.BeansException;
import com.noblegaesgoo.springframework.beans.factory.BeanFactory;
import com.noblegaesgoo.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 11:20
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: AbstractBeanFactory
 * @Description: 核心类，bean抽象工厂
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {

    /**
     * 从容其中拿取指定名称的实例化后的bean（默认bean实例为单例），模板方法模式
     * @param name
     * @return 指定名称实例化后的bean对象
     */
    @Override
    public Object getBean(String name) {

        // 首先尝试从bean实例化容器中获取该bean的实例对象
        Object singletonBean = getSingleton(name);
        // 若实例对象存在则直接返回
        if (singletonBean != null) {
            return singletonBean;
        }

        // 不存在则从bean注册信息容器中获取该bean的注册信息
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 根据对应bean的注册信息以及名称实例化该bean，并存入实例化bean容器中
        return createBean(name, beanDefinition);
    }

    /**
     * 根据beanDefinitionName获取对应bean的BeanDefinition信息，模板方法
     * @param beanDefinitionName
     * @return 对应beanDefinitionName的bean注册信息
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanDefinitionName) throws BeansException;

    /**
     * 根据beanName从BeanDefinition容器中取出信息并实例化，模板方法
     * @param beanName
     * @param beanDefinition
     * @return 对应beanName的实例化对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
