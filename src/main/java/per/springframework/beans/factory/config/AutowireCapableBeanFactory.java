package per.springframework.beans.factory.config;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.BeanFactory;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean  existingBean
     * @param beanName      beanName
     * @return obj
     * @throws BeansException e
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean  existingBean
     * @param beanName      beanName
     * @return obj
     * @throws BeansException e
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
