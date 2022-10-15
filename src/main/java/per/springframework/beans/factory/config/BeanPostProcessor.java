package per.springframework.beans.factory.config;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     bean
     * @param beanName beanName
     * @return bean obj
     * @throws BeansException e
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     bean
     * @param beanName beanName
     * @return bean obj
     * @throws BeansException e
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
