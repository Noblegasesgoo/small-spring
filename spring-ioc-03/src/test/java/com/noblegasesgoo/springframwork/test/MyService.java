package com.noblegasesgoo.springframwork.test;

/**
 * @author: noblegasesgoo
 * @CreateDate: 2022年08月29日 15:50
 * @ProjectName: small-spring-private
 * @version: 0.0.1
 * @FileName: MyService
 * @Description:
 */
public class MyService {

    private Integer test;

    public MyService(Integer test) {
        this.test = test;
    }

    public void doTest() {
        System.out.println(test);
        System.out.println("测试成功");
    }
}
