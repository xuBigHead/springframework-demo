package per.springframework.context.support;

import per.springframework.beans.factory.support.DefaultListableBeanFactory;
import per.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Objects;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(Objects.nonNull(configLocations)) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
