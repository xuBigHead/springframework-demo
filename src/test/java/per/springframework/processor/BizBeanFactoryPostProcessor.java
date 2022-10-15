package per.springframework.processor;

import per.springframework.beans.BeansException;
import per.springframework.beans.PropertyValue;
import per.springframework.beans.PropertyValues;
import per.springframework.beans.factory.config.BeanDefinition;
import per.springframework.beans.factory.config.BeanFactoryPostProcessor;
import per.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/8/30
 */
@Slf4j
public class BizBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("在对象属性配置中注入自定义属性");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userBiz");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("beanFactoryInjectField", "inject by beanFactoryPostProcessor"));
    }
}
