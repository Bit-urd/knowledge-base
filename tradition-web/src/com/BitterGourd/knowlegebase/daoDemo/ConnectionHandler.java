package com.BitterGourd.knowlegebase.daoDemo;

        import java.lang.reflect.InvocationHandler;
        import java.lang.reflect.Method;
        import java.lang.reflect.Proxy;
        import java.sql.Connection;

/**
 * @Program: knowledge-base
 * @Description: ConnectionHandler
 * @Author: BitterGourd
 * @Date: 2020-01-17 20:18
 */
public class ConnectionHandler implements InvocationHandler {

    private Connection realConnection;
    private Connection warpedConnection;
    private DataSourcePool dataSourcePool;

    ConnectionHandler(DataSourcePool dataSourcePool){
        this.dataSourcePool = dataSourcePool;
    }

    Connection bind(Connection realConn){
        // 动态代理 需要 类加载器、实现的接口、调用处理器(实现InvocationHandler)
        this.realConnection = realConn;
        this.warpedConnection =
                (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                        new Class[]{Connection.class},this);
        return warpedConnection;  // 内存里面生成Class实现接口，对这个class的请求转发给处理器,
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("close".equals(method.getName())){
            this.dataSourcePool.free(this.warpedConnection);
        }
        // 其他的都转发给真正的连接了 真正感兴趣的只有close方法
        return method.invoke(this.realConnection,args);
    }


    /*
     * DataSourcePool、增加连接数
     * 1. new 一个handler
     * 2. 调用bind，绑定一个 实例对象
     *
     * */

}
