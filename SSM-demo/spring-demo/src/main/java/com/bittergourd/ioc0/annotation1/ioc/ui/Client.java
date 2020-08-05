package com.bittergourd.ioc0.annotation.ioc.ui;

import com.bittergourd.ioc0.annotation.ioc.service.IAccountService;
import com.bittergourd.ioc0.annotation.ioc.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("com/bittergourd/ioc0/beanan.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
//        IAccountService as2  = (IAccountService)ac.getBean("accountService");
//        System.out.println(as);
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
//        System.out.println(as == as2);
        as.saveAccount();
        ac.close();
    }
}
