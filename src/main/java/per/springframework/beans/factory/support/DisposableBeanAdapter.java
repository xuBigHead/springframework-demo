package per.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import per.springframework.beans.BeansException;
import per.springframework.beans.factory.DisposableBean;
import per.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author mangmang.xu
 * @since 2021/8/31
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if(bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        if(StrUtil.isNotEmpty(this.destroyMethodName)
            && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(this.destroyMethodName);
            if(null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '"
                    + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
