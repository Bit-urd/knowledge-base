package com.bittergourd.ioc0.xml.spring2.service.impl;

import com.bittergourd.ioc0.xml.spring2.dao.IAccountDao;
import com.bittergourd.ioc0.xml.spring2.service.IAccountService;
import com.bittergourd.ioc0.xml.spring2.dao.IAccountDao;
import com.bittergourd.ioc0.xml.spring2.service.IAccountService;

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
