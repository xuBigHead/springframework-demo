package per.springframework.common;

import java.io.Serializable;

/**
 * @author mangmang.xu
 */
public interface IResultCode extends Serializable {
    /**
     * 获取消息
     *
     * @return msg
     */
    String getMessage();

    /**
     * 获取状态码
     *
     * @return http code
     */
    int getCode();
}
