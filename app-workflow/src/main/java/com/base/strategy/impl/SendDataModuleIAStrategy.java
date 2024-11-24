package com.base.strategy.impl;

import com.base.dto.MealPlanDto;
import com.base.mealPlan.GenerateMealPlanApi;
import com.base.business.application.Business;
import com.base.dto.ProfileNutritionToModuleIADtoRequest;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class SendDataModuleIAStrategy implements IStrategy {

    @Autowired
    private GenerateMealPlanApi generateMealPlanApi;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){
            MealPlanDto response = generateMealPlanApi.generateMealPlanPrimary(business.getObject(ProfileNutritionToModuleIADtoRequest.class));
            business.addObject(response);
        }
    }
}
