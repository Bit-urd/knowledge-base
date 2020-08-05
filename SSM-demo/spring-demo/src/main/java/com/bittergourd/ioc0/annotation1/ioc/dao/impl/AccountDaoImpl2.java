package com.bittergourd.ioc0.annotation1.ioc.dao.impl;

import com.bittergourd.ioc0.annotation1.ioc.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2  implements IAccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户2222222222222");
    }
}
