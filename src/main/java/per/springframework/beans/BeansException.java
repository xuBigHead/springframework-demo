package per.springframework.beans;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
