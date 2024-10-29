package com.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProfileNutritionToMealPlan {

    private String name;

    private ProfileNutrition profileNutrition;
}
