package com.base.facade.profileNutritionFacade;

import com.base.domain.ProfileNutrition;
import com.base.service.ProfileNutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileNutritionFacade {

    @Autowired
    private ProfileNutritionService service;

    public ProfileNutrition RegisterProfileNutrition(ProfileNutrition profileNutrition){
        return service.registerProfileNutrition(profileNutrition);
    }
}
