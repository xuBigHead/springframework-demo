package per.springframework.beans.factory;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
