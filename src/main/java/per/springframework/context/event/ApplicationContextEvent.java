package per.springframework.context.event;

import per.springframework.context.ApplicationContext;
import per.springframework.context.ApplicationEvent;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
