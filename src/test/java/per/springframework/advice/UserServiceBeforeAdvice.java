package per.springframework.advice;

import per.springframework.aop.aspectj.MethodBeforeAdvice;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author mangmang.xu
 * @since 2021/9/14
 */
@Slf4j
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("前置拦截方法:[{}]", method.getName());
    }
}
