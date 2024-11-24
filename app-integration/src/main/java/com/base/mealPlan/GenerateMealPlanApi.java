package com.base.mealPlan;

import com.base.dto.moduleIA.MealPlanDto;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import org.springframework.stereotype.Component;

@Component
public class GenerateMealPlanApi extends WebClientApplication{

    public MealPlanDto generateMealPlanPrimary(ProfileNutritionToModuleIADtoRequest profileNutrition){
         return post("/create/meal_plan", profileNutrition, MealPlanDto.class );
    }
}
