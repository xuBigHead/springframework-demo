package per.springframework.context;

/**
 * @author mangmang.xu
 * @since 2021/9/3
 */
public interface ApplicationEventPublisher {
    /**
     * 发布事件
     *
     * @param event 事件对象
     */
    void publishEvent(ApplicationEvent event);
}
