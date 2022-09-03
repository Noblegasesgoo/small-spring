package com.noblegasesgoo.springframwork.beans.factory.support;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.BeanFactory;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;
import com.noblegasesgoo.springframwork.beans.factory.impl.DefaultSingletonBeanFactory;

import java.util.Objects;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:07
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: AbstractBeanFactory
 * @Description: 核心类，bean模板抽象工厂
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {

    /**
     * 从容其中拿取指定名称的实例化后的bean（默认bean实例为单例）
     * @param beanName
     * @return 指定名称实例化后的bean对象
     */
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    /**
     * 从容器中拿取指定名称、指定构造函数并且实例化之后的bean（默认bean实例为单例）
     * @param beanName
     * @param args
     * @return 指定名称、指定构造函数并且实例化之后的bean（默认bean实例为单例）
     * @throws BeansException
     */
    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * getBean模板方法
     * @param name
     * @param args
     * @param <T>
     * @return 对应bean
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 首先尝试从bean实例化容器中获取该bean的实例对象
        Object bean = getSingleton(name);
        if (!Objects.isNull(bean)) {
            return (T) bean;
        }
        // 不存在则从bean注册信息容器中获取该bean的注册信息
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 根据对应bean的注册信息以及名称实例化该bean，并存入实例化bean容器中
        return (T) createBean(name, beanDefinition, args);
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
     * @param args
     * @return 对应beanName的实例化对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
