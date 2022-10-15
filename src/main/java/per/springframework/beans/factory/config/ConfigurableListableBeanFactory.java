package per.springframework.beans.factory.config;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.ListableBeanFactory;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
