package per.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.URL;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if(location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        try {
            URL url = new URL(location);
            return new UrlResource(url);
        } catch (Exception e) {
            return new FileSystemResource(location);
        }
    }
}
