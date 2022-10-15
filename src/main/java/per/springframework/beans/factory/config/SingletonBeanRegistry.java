package per.springframework.beans.factory.config;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
