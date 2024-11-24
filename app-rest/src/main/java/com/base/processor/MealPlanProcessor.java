package com.base.processor;

import com.base.business.application.Business;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import com.base.navigator.MealPlanNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class MealPlanProcessor {

    @Autowired
    private MealPlanNavigator navigation;

    public ResponseEntity<?> registerProcessor(){

        Business business = getSession();
        business.addObject(new ProfileNutritionToModuleIADtoRequest(business.getUser().getName(), business.getUser().getProfileNutrition()));

        navigation.generateMealPlanNavigation();

        return null;

    }
}
