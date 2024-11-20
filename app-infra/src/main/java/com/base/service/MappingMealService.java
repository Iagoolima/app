package com.base.service;

import com.base.domain.MappingMeal;
import com.base.repository.MappingMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingMealService {

    @Autowired
    private MappingMealRepository repository;

    public List<MappingMeal> findAll(){
        return repository.findAll();
    }
}
