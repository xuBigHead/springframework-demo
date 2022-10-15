package per.springframework;

import per.springframework.aop.TargetSource;
import per.springframework.aop.aspectj.AspectJExpressionPointcut;
import per.springframework.aop.framework.AdvisedSupport;
import per.springframework.aop.framework.CglibAopProxy;
import per.springframework.aop.framework.JdkDynamicAopProxy;
import per.springframework.bean.UserServiceInterceptor;
import per.springframework.beans.PropertyValue;
import per.springframework.beans.PropertyValues;
import per.springframework.beans.factory.config.BeanDefinition;
import per.springframework.beans.factory.config.BeanReference;
import per.springframework.beans.factory.support.DefaultListableBeanFactory;
import per.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import per.springframework.biz.UserBiz;
import per.springframework.biz.impl.UserBizImpl;
import per.springframework.context.event.CustomEvent;
import per.springframework.context.support.ClassPathXmlApplicationContext;
import per.springframework.processor.BizBeanFactoryPostProcessor;
import per.springframework.processor.BizBeanPostProcessor;
import per.springframework.service.UserService;
import per.springframework.service.impl.UserServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
@Slf4j
public class SpringTest {
    @Test
    public void aop(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/springAop.xml");
        UserService userService = applicationContext.getBean("userService", UserServiceImpl.class);
        System.out.println("测试结果：" + userService.queryUserName());
    }

    @Test
    public void dynamicProxy(){
        UserService userService = new UserServiceImpl();
        AdvisedSupport advised = new AdvisedSupport();
        advised.setTargetSource(new TargetSource(userService));
        advised.setMethodInterceptor(new UserServiceInterceptor());
        advised.setMethodMatcher(new AspectJExpressionPointcut("execution(* per.springframework.service.UserService.*(..))"));

        UserService jdkProxyUserService = (UserService) new JdkDynamicAopProxy(advised).getProxy();
        log.info("JDK代理方法结果：[{}]\r\n", jdkProxyUserService.queryUserName());

        UserService cglibProxyUserService = (UserService) new CglibAopProxy(advised).getProxy();
        log.info("CGLIB代理方法结果：[{}]\r\n", cglibProxyUserService.queryUserName());
    }

    @Test
    @SneakyThrows
    public void matchMethodByAop(){
        AspectJExpressionPointcut pointcut =
            new AspectJExpressionPointcut("execution(* per.springframework.biz.UserBiz.*(..))");
        Class<UserBiz> userBizClass = UserBiz.class;
        String methodName = "queryUserName";
        Method method = userBizClass.getDeclaredMethod(methodName);

        log.info("拦截方法[{}][{}]", method, pointcut.matches(userBizClass) ? "成功" : "失败");
        log.info("拦截方法[{}][{}]", method, pointcut.matches(method, userBizClass) ? "成功" : "失败");
    }

    @Test
    public void listener(){
        // 初始化配置时发布刷新事件
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/springScope.xml");

        // 发布自定义事件
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1L, "自定义事件"));
        applicationContext.getBean("userBiz", UserBiz.class);

        // 关闭容器时发布关闭事件
        applicationContext.close();
    }

    @Test
    public void factoryBean(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/springScope.xml");

        UserBiz userBiz = applicationContext.getBean("userBiz", UserBiz.class);
        String username = userBiz.queryUserName();
        log.info("username value is [{}]", username);
    }

    @Test
    public void scope(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/springScope.xml");

        UserBiz userBiz1 = applicationContext.getBean("userBiz", UserBiz.class);
        UserBiz userBiz2 = applicationContext.getBean("userBiz", UserBiz.class);
        log.info("当前对象作用域是[{}]模式", userBiz1 == userBiz2 ? "单例" : "原型");
    }

    @Test
    public void aware(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/spring.xml");

        applicationContext.getBean("userBiz", UserBiz.class);
    }

    @Test
    public void executeInitAndDestroyMethod(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/spring.xml");
        applicationContext.registerShutdownHook();

        applicationContext.getBean("userBiz", UserBiz.class);
    }

    @Test
    public void modifyFieldBeforeAndAfterBeanInitByXml(){
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:springframework/springProcessor.xml");

        UserBiz userBiz = applicationContext.getBean("userBiz", UserBiz.class);
        userBiz.init();
    }

    @Test
    public void modifyFieldBeforeAndAfterBeanInit(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:springframework/spring.xml");

        BizBeanFactoryPostProcessor bizBeanFactoryPostProcessor = new BizBeanFactoryPostProcessor();
        bizBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        BizBeanPostProcessor bizBeanPostProcessor = new BizBeanPostProcessor();
        beanFactory.addBeanPostProcessor(bizBeanPostProcessor);

        UserBiz userBiz = beanFactory.getBean("userBiz", UserBiz.class);
        userBiz.init();
    }

    @Test
    public void getBeanWithXml(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:springframework/spring.xml");

        // 3. 获取Bean对象调用方法
        UserBiz testUserBiz = beanFactory.getBean("testUserBiz", UserBiz.class);
        testUserBiz.init();
    }

    @Test
    public void getBeanWithAutowiredField(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("testUserService", new BeanDefinition(UserServiceImpl.class));

        PropertyValues propertyValues = new PropertyValues();
        PropertyValue userPropertyValue = new PropertyValue("testUserService", new BeanReference("testUserService"));
        propertyValues.addPropertyValue(userPropertyValue);

        beanFactory.registerBeanDefinition("userBiz", new BeanDefinition(UserBizImpl.class, propertyValues));
        UserBiz userBiz = (UserBiz) beanFactory.getBean("userBiz", new UserServiceImpl());
        userBiz.init();
    }

    @Test
    public void getBean() {
        // init beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // init beanDefinition and register into beanFactory
        BeanDefinition beanDefinition = new BeanDefinition(UserBizImpl.class);
        beanFactory.registerBeanDefinition("userBiz", beanDefinition);

        // get bean by name
        UserBiz userBiz = (UserBiz) beanFactory.getBean("userBiz", new UserServiceImpl());
        userBiz.init();
    }
}
