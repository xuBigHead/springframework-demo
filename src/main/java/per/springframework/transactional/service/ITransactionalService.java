package per.springframework.transactional.service;

/**
 * @author mangmang.xu
 * @since 2022/9/27
 */
public interface ITransactionalService {
    void exceptionCatch();

    void throwException();

    void handRollback();
}
