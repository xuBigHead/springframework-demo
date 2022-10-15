package per.springframework.beans.factory;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
