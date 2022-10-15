package per.springframework.context;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.Aware;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
