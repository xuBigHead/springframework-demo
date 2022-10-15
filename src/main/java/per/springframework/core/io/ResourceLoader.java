package per.springframework.core.io;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface ResourceLoader {
    /**
     *
     */
    String CLASSPATH_URL_PREFIX = "classpath:";
    
    Resource getResource(String location);
}
