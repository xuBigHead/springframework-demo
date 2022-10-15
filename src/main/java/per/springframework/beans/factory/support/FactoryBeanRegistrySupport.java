package per.springframework.beans.factory.support;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object != NULL_OBJECT ? object : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if(factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if(object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, object != null ? object : NULL_OBJECT);
            }
            return object != NULL_OBJECT ? object : null;
        }
        return doGetObjectFromFactoryBean(factory, beanName);
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
