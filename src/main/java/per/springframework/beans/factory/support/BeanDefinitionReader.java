package per.springframework.beans.factory.support;

import per.springframework.beans.BeansException;
import per.springframework.core.io.Resource;
import per.springframework.core.io.ResourceLoader;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;
}
