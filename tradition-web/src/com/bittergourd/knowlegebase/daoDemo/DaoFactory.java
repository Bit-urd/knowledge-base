package com.bittergourd.knowlegebase.daoDemo;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Program: knowledge-base
 * @Description: DaoFactory
 * @Author: bittergourd
 * @Date: 2020-01-15 22:26
 */
class UserDao{

}

public class DaoFactory {
    private static DaoFactory instance = new DaoFactory();
    private static UserDao userDao = null;
    /**
     * 这块有错的原因,初始化 static时
     * 先执行DaoFactory 初始化userDao，又把userDao赋值为空
     * */
    private DaoFactory(){
        Properties prop = new Properties();
        try (
//                InputStream in = new FileInputStream(new File("src/daoconf.properties"));
                InputStream in = this.getClass().getClassLoader()
                        .getResourceAsStream("daoconf.properties");
        ){
            prop.load(in);
            String userClzString = prop.getProperty("UserDaoClass");
            Class<UserDao> clz = (Class<UserDao>) Class.forName(userClzString);
            UserDao userDao =  clz.newInstance();
        } catch (Exception e) {
            new ExceptionInInitializerError();  // 不能隐藏异常
        }
    }

    public DaoFactory getDaoFactory(){
        return instance;
    }

    public UserDao getUserDao(){
        return userDao;
    }
}
