package per.springframework.context.event;

import per.springframework.beans.factory.BeanFactory;
import per.springframework.context.ApplicationEvent;

/**
 * @author mangmang.xu
 * @since 2021/9/3
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
