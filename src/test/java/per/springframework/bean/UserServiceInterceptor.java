package per.springframework.bean;


import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author mangmang.xu
 * @since 2021/9/13
 */
@Slf4j
public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            log.info("开始通过代理监控");
            log.info("方法名称[{}]", invocation.getMethod());
            log.info("方法耗时[{}]ms", System.currentTimeMillis() - start);
            log.info("监控结束");
        }
    }
}
