package per.springframework.beans.factory;

/**
 * @author mangmang.xu
 * @since 2021/9/1
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
