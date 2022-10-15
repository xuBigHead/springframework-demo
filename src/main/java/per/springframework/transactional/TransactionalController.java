package per.springframework.transactional;

import com.core.tool.constant.StringPool;
import com.core.tool.result.R;
import per.springframework.transactional.service.ITransactionalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mangmang.xu
 * @since 2022/9/27
 */
@RestController
@AllArgsConstructor
public class TransactionalController {
    private final ITransactionalService transactionalService;

    @GetMapping("/exception-catch")
    public R<?> exceptionCatch() {
        transactionalService.exceptionCatch();
        transactionalService.throwException();
        transactionalService.handRollback();
        return R.success(StringPool.SUCCESS);
    }
}
