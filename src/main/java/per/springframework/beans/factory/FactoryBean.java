package per.springframework.beans.factory;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
