package per.springframework.beans.factory.config;

import per.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
