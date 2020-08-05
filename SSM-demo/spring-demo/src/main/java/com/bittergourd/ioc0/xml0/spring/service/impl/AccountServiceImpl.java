package com.bittergourd.ioc0.xml.spring.service.impl;

import com.bittergourd.ioc0.xml.spring.dao.IAccountDao;
import com.bittergourd.ioc0.xml.spring.service.IAccountService;
import com.bittergourd.ioc0.xml.spring.dao.IAccountDao;
import com.bittergourd.ioc0.xml.spring.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao ;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
