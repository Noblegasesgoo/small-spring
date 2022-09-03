package com.noblegasesgoo.springframwork.beans.factory.strategy;

import com.noblegasesgoo.springframwork.beans.BeansException;
import com.noblegasesgoo.springframwork.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 14:49
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: CglibSubclassingInstantiationStrategy
 * @Description: cglib动态代理实例化bean策略
 */

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    /**
     * bean实例化策略
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return 实例化之后的对象
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (Objects.isNull(constructor)) {
            // 选用无参构造
            return enhancer.create();
        }
        // 选用指定参数的有参构造
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
