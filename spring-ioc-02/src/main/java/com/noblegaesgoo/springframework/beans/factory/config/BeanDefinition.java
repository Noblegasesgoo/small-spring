package com.noblegaesgoo.springframework.beans.factory.config;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 11:19
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeanDefinition
 * @Description: Bean定义信息
 */

public class BeanDefinition {

    /**
     * 这里我们用 class 对象的原因就是：
     * 不想将bean的注册和实例化耦合在一起
     */
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
