package per.springframework.transactional.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import per.springframework.transactional.service.ITransactionalService;

/**
 * @author mangmang.xu
 * @since 2022/9/27
 */
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionalService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void exceptionCatch() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 异常被捕获导致事务失效
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void throwException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 将异常抛出
            throw new RuntimeException("error");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handRollback() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 手动设置事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}

