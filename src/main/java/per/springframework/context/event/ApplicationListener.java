package per.springframework.context.event;

import per.springframework.context.ApplicationEvent;

import java.util.EventListener;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
