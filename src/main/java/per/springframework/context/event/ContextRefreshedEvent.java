package per.springframework.context.event;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
