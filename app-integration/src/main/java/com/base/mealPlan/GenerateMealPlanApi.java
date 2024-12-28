package com.base.mealPlan;

import com.base.WebClientApplication;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import org.springframework.stereotype.Component;

@Component
public class GenerateMealPlanApi extends WebClientApplication {

    public MealPlanDtoResponse generateMealPlanPrimary(ProfileNutritionToModuleIADtoRequest profileNutrition){
         return post("/create/meal_plan", profileNutrition, MealPlanDtoResponse.class );
    }
}
