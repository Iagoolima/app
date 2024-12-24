package com.base.dto.moduleIA;

import lombok.Data;

import java.util.List;

@Data
public class MealPlanDtoResponse {

    private int totalCalories;
    private String message;
    private List<MealDtoResponse> meals;
}
