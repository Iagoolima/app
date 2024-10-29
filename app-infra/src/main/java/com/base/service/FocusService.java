package com.base.service;

import com.base.domain.Focus;
import com.base.repository.FocusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FocusService {

    @Autowired
    private FocusRepository repository;

    public Focus findById(int id){
        Optional<Focus> optionalFocus = repository.findById(id);
        if(optionalFocus.isEmpty())
            throw new RuntimeException("error");

        return optionalFocus.get();
    }
}
