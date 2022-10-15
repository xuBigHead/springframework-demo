package per.springframework.context.event;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/9/3
 */
@Slf4j
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("刷新事件：[{}]", this.getClass().getName());
    }
}
