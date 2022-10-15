package per.springframework.biz;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
public interface UserBiz {
    String queryUserName();

    void init();

    void destroy();
}
