package per.springframework.context.event;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/9/3
 */
@Slf4j
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("关闭事件：[{}]", this.getClass().getName());
    }
}
