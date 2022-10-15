package per.springframework.context;

import per.springframework.beans.BeansException;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
public interface ConfigurableApplicationContext extends ApplicationContext  {
    /**
     * 刷新容器
     *
     * @throws BeansException e
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
