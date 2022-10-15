package per.springframework.aop;

/**
 * @author mangmang.xu
 * @since 2021/9/14
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
