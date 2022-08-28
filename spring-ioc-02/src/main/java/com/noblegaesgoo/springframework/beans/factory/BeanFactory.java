package com.noblegaesgoo.springframework.beans.factory;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 11:17
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeanFactory
 * @Description: bean工厂能力提供接口
 */

public interface BeanFactory {

    /**
     * 从容其中拿取指定名称的实例化后的bean（默认bean实例为单例）
     * @param name
     * @return 指定名称实例化后的bean对象
     */
    Object getBean(String name);
}
