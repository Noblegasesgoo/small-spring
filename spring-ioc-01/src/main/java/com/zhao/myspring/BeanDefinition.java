package com.zhao.myspring;

/**
 * @author noblegasesgoo
 * @version 0.0.1
 * @date 2022/7/26 16:28
 * @description 简易BeanDefinition
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
