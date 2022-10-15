package per.springframework.aop;

/**
 * @author mangmang.xu
 * @since 2021/9/7
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
