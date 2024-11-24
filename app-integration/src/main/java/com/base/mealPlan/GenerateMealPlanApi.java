package com.base.mealPlan;

import com.base.dto.MealPlanDto;
import com.base.dto.ProfileNutritionToModuleIADtoRequest;
import org.springframework.stereotype.Component;

@Component
public class GenerateMealPlanApi extends WebClientApplication{

    public MealPlanDto generateMealPlanPrimary(ProfileNutritionToModuleIADtoRequest profileNutrition){
         return post("/create/meal_plan", profileNutrition, MealPlanDto.class );
    }
}
