package per.springframework.context.event;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author mangmang.xu
 * @since 2021/9/3
 */
@Slf4j
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("收到：[{}]消息，时间：[{}]", event.getSource(), new Date());
        log.info("消息：[{}]，内容：[{}]", event.getId(), event.getMessage());
    }
}
