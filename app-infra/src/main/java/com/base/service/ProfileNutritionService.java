package com.base.service;

import com.base.domain.ProfileNutrition;
import com.base.repository.ProfileNutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileNutritionService {

    @Autowired
    private ProfileNutritionRepository repository;

    public ProfileNutrition registerProfileNutrition(ProfileNutrition profileNutrition){
        return repository.save(profileNutrition);
    }

}
