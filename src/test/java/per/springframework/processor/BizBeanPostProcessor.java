package per.springframework.processor;

import per.springframework.beans.BeansException;
import per.springframework.beans.factory.config.BeanPostProcessor;
import per.springframework.biz.impl.UserBizImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/8/30
 */
@Slf4j
public class BizBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("在对象[{}]实例化之前注入属性", beanName);
        if("userBiz".equals(beanName)) {
            UserBizImpl userBiz = (UserBizImpl) bean;
            userBiz.setBeanFactoryInjectField("对象工厂注入的属性");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug("在对象[{}]实例化之后注入属性", beanName);
        return bean;
    }
}
