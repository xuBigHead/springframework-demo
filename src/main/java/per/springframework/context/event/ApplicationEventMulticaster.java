package per.springframework.context.event;

import per.springframework.context.ApplicationEvent;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public interface ApplicationEventMulticaster {
    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
