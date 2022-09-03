package com.noblegasesgoo.springframwork.beans.factory.support;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;
import com.noblegasesgoo.springframwork.beans.factory.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:08
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: AbstractAutowireCapableBeanFactory
 * @Description: 真正执行创建bean实例对象抽象工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * bean实例化策略
     */
    private InstantiationStrategy instantiationStrategy;

    /**
     * 根据beanName从BeanDefinition容器中取出信息并实例化
     * @param beanName
     * @param beanDefinition
     * @return 对应beanName的实例化对象
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 通过bean注册信息实例化bean
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 将实例化完毕的bean存入实例化容器对象中去
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        // 具体要使用的构造函数
        Constructor constructorToUse = null;
        // 获得对应bean注册信息中bean的class
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 通过该bean的class对象获得bean中的所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 找到符合条件的构造函数
        for (Constructor ctor : declaredConstructors) {
            if (!Objects.isNull(args) && ctor.getParameterTypes().length == args.length) {
                // 当前待实例化的bean的构造函数的对应参数不为空且参数长度匹配上的话就记录
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 获得策略实现类
     * @return 具体策略实现类
     */
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * 设置策略实现类
     * @param instantiationStrategy
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
