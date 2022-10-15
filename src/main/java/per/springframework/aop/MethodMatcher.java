package per.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author mangmang.xu
 * @since 2021/9/7
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
