package per.springframework.context.support;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.config.BeanPostProcessor;
import per.springframework.context.ApplicationContext;
import per.springframework.context.ApplicationContextAware;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}