package per.springframework.aop.aspectj;

import per.springframework.aop.Pointcut;
import per.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author mangmang.xu
 * @since 2021/9/14
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 具体的拦截方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    @Override
    public Pointcut getPointcut() {
        if(null == pointcut) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
