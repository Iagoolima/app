package com.base.strategy.impl;

import com.base.constants.MealPlanConstants;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import com.base.mealPlan.GenerateMealPlanApi;
import com.base.business.application.Business;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import com.base.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.base.business.application.Business.getSession;

@Component
public class SendProfileNutritionModuleIAStrategy implements IStrategy {

    @Autowired
    private GenerateMealPlanApi generateMealPlanApi;

    @Autowired
    private MealPlanConstants constants;

    @Override
    public void execute() {

        Business business = getSession();

        if(!business.isError()){
            MealPlanDtoResponse response = generateMealPlanApi.generateMealPlanPrimary(business.getObject(ProfileNutritionToModuleIADtoRequest.class));

            if(response == null)
                business.setError(constants.errorGenerateMealPlan, business.getUser().getId(), SendProfileNutritionModuleIAStrategy.class);

            business.addObject(response);
        }
    }
}
