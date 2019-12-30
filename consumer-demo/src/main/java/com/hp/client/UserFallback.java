package com.hp.client;

import com.hp.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("呵呵呵又拥堵了");
        return user;
    }
}
