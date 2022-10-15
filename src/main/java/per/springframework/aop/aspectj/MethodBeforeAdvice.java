package per.springframework.aop.aspectj;

import per.springframework.aop.BeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author mangmang.xu
 * @since 2021/9/14
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
