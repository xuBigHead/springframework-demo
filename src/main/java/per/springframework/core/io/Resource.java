package per.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
