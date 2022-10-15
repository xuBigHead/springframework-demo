package per.springframework.beans.factory.support;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author mangmang.xu
 * @since 2021/8/6
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
