package per.springframework.beans.factory.config;

import lombok.Data;

/**
 * @author mangmang.xu
 * @since 2021/8/6
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
