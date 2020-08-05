package com.bittergourd.ioc0.xml0.spring3.ui;

import com.bittergourd.ioc0.xml0.spring3.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml0");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/bittergourd/ioc0/bean.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        as.saveAccount();

        //手动关闭容器
        ac.close();
    }
}
