package com.base.mealPlan;

import com.base.WebClientApplication;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import com.base.dto.moduleIA.ProfileNutritionToModuleIADtoRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GenerateMealPlanApi extends WebClientApplication {

    @Bean
    public MealPlanDtoResponse generateMealPlanPrimary(ProfileNutritionToModuleIADtoRequest profileNutrition){
         return post("/create/meal_plan", profileNutrition, MealPlanDtoResponse.class );
    }
}
