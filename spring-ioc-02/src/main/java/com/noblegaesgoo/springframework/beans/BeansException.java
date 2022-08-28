package com.noblegaesgoo.springframework.beans;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月28日 11:17
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: BeansException
 * @Description: Beans核心包的异常类
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
