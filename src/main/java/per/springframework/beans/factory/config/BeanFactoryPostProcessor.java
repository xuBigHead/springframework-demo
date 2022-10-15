package per.springframework.beans.factory.config;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory beanFactory
     * @throws BeansException e
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
