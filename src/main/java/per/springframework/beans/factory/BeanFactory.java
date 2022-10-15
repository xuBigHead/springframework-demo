package per.springframework.beans.factory;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
