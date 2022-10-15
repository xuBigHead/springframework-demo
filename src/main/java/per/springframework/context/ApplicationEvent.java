package per.springframework.context;

import java.util.EventObject;

/**
 * @author mangmang.xu
 * @since 2021/9/2
 */
public abstract class ApplicationEvent extends EventObject {
    public ApplicationEvent(Object source) {
        super(source);
    }
}
