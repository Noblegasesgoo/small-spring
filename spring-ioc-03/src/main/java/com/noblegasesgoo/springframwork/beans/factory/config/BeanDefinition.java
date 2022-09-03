package com.noblegasesgoo.springframwork.beans.factory.config;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:05
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeanDefinition
 * @Description: Bean定义信息实体类
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
