package com.base.dto;

import com.base.domain.ProfileNutrition;
import lombok.Data;

@Data
public class MealPlanOneDtoResponse {

    private ProfileNutrition profileNutrition;

    private int totalCalories;

    private MealOneDtoResponse meal;

}
