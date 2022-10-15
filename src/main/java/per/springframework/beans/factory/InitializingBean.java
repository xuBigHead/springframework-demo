package per.springframework.beans.factory;

/**
 * @author mangmang.xu
 * @since 2021/8/31
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception e
     */
    void afterPropertiesSet() throws Exception;
}
