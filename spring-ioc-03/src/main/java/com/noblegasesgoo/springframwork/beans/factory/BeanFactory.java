package com.noblegasesgoo.springframwork.beans.factory;

import com.noblegasesgoo.springframwork.beans.BeansException;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:05
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeanFactory
 * @Description: bean工厂能力提供接口
 */
public interface BeanFactory {

    /**
     * 从容其中拿取指定名称的实例化后的bean（默认bean实例为单例）
     * @param beanName
     * @return 指定名称实例化后的bean对象
     */
    Object getBean(String beanName);

    /**
     * 从容器中拿取指定名称、指定构造函数并且实例化之后的bean（默认bean实例为单例）
     * @param beanName
     * @param args
     * @return 指定名称、指定构造函数并且实例化之后的bean（默认bean实例为单例）
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
