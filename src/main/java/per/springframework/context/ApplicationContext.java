package per.springframework.context;

import per.springframework.beans.factory.HierarchicalBeanFactory;
import per.springframework.beans.factory.ListableBeanFactory;
import per.springframework.core.io.ResourceLoader;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
