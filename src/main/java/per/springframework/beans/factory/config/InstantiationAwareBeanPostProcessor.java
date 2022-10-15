package per.springframework.beans.factory.config;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/9/14
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
