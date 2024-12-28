package com.base.facade.userFacade;

import com.base.domain.User;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    private UserService service;

    public void updateUser(User user){
        service.update(user);
    }
}
