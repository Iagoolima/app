package com.base.dto;

import com.base.domain.Meal;
import lombok.Data;

import java.util.List;

@Data
public class ModuleIAToMealPlanDTO {

    private int totalCalories;
    private String message;
    private List<Meal> meals;
}
