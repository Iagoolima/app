package com.base.mealPlan;

import com.base.dto.ModuleIAToMealPlanDTO;
import com.base.dto.ProfileNutritionToModuleIARequestDTO;
import org.springframework.stereotype.Component;

@Component
public class GenerateMealPlanApi extends WebClientApplication{

    public ModuleIAToMealPlanDTO generateMealPlanPrimary(ProfileNutritionToModuleIARequestDTO profileNutrition){
         return post("/create/meal_plan", profileNutrition, ModuleIAToMealPlanDTO.class );
    }
}
