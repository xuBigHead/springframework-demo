package per.springframework.aop;

/**
 * @author mangmang.xu
 * @since 2021/9/7
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
