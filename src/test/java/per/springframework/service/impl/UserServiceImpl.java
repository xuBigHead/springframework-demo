package per.springframework.service.impl;

import per.springframework.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mangmang.xu
 * @since 2021/8/5
 */
@Data
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public String queryUserName() {
        return "username";
    }
}
