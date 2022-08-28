package com.zhao.myspring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author noblegasesgoo
 * @version 0.0.1
 * @date 2022/7/26 16:28
 * @description 简易bean工厂
 */
public class BeanFactory {

    // IOC容器
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 根据beanName获取对应的bean
     * @param name
     * @return 对应BeanName的Bean
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 将bean注册到容器中
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
