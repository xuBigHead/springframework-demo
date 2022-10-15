package per.springframework.biz.impl;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.BeanClassLoaderAware;
import per.springframework.beans.factory.BeanFactory;
import per.springframework.beans.factory.BeanFactoryAware;
import per.springframework.beans.factory.BeanNameAware;
import per.springframework.biz.UserBiz;
import per.springframework.context.ApplicationContext;
import per.springframework.context.ApplicationContextAware;
import per.springframework.service.CompanyService;
import per.springframework.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
@Data
@Slf4j
public class UserBizImpl implements UserBiz, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private CompanyService companyService;
    private UserService userService;
    private String beanFactoryInjectField;

    public UserBizImpl() {
        log.info("通过空参构造器实例化对象");
    }

    public UserBizImpl(UserService userService) {
        log.info("inject field testUserService");
        this.userService = userService;
    }

    public void setCompanyService(CompanyService companyService) {
        log.info("set testCompanyService after init");
        this.companyService = companyService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String queryUserName() {
        return userService.queryUserName();
    }

    @Override
    public void init() {
        log.info("初始化 userBiz 对象成功");
    }

    @Override
    public void destroy() {
        log.info("销毁 userBiz 对象成功");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("对象工厂感知器注入对象工厂");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("应用上下文感知器注入应用上下文");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        log.info("Bean Name is : [{}]", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("ClassLoader : [{}]", classLoader);
    }
}
