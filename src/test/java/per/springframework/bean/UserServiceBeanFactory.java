package per.springframework.bean;

import per.springframework.beans.factory.FactoryBean;
import per.springframework.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public class UserServiceBeanFactory implements FactoryBean<UserService> {
    @Override
    public UserService getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) return this.toString();
            return "你被代理了: " + method.getName();
        };
        return (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserService.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
