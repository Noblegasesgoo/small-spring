package com.noblegaesgoo.springframework.beans.factory.support;

import com.noblegaesgoo.springframework.beans.BeansException;
import com.noblegaesgoo.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 16:30
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: AbstractAutowireCapableBeanFactory
 * @Description: 真正执行创建bean实例对象抽象工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 根据beanName从BeanDefinition容器中取出信息并实例化
     * @param beanName
     * @param beanDefinition
     * @return 对应beanName的实例化对象
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {

        Object bean;

        try {
            // 通过bean注册信息实例化bean
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 将实例化完毕的bean存入实例化容器对象中去
        addSingleton(beanName, bean);
        return bean;
    }
}
