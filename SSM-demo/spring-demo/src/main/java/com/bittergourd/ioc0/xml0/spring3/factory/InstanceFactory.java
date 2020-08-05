package com.bittergourd.ioc0.xml.spring3.factory;

import com.bittergourd.ioc0.xml.spring3.service.IAccountService;
import com.bittergourd.ioc0.xml.spring3.service.impl.AccountServiceImpl;
import com.bittergourd.ioc0.xml.spring3.service.IAccountService;
import com.bittergourd.ioc0.xml.spring3.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
