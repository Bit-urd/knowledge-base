package com.bittergourd.ioc0.byebyexxml2;

import com.bittergourd.ioc0.byebyexxml2.config.SpringConfiguration;
import com.bittergourd.ioc0.byebyexxml2.service.IAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Program: knowledge-base
 * @Description: MyTest
 * @Author: Biturd
 * @Date: 2020-06-16 20:58
 */
public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println(ac.getBean(IAccountService.class));
    }
}
