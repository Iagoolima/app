package com.base.service;

import com.base.domain.User;
import com.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void update(User user){
        repository.save(user);
    }
}
