package per.springframework.context.event;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
