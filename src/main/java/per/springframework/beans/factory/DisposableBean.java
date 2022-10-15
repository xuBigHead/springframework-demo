package per.springframework.beans.factory;

/**
 * @author mangmang.xu
 * @since 2021/8/31
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
