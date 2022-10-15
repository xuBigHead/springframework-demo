package per.springframework.beans.factory.support;

import per.springframework.beans.factory.config.BeanDefinition;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName          beanName
     * @param beanDefinition    beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
