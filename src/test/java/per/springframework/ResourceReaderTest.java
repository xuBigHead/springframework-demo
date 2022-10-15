package per.springframework;

import cn.hutool.core.io.IoUtil;
import per.springframework.core.io.DefaultResourceLoader;
import per.springframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mangmang.xu
 * @since 2021/8/26
 */
@Slf4j
public class ResourceReaderTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClasspath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:springframework/important.properties");
        printResourceContent(resource);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/springframework/important.properties");
        printResourceContent(resource);
    }

    @Test
    public void testUrl() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        printResourceContent(resource);
    }

    private void printResourceContent(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
