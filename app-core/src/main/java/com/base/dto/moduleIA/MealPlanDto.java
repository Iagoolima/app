package com.base.dto.moduleIA;

import lombok.Data;

import java.util.List;

@Data
public class MealPlanDto {

    private int totalCalories;
    private String message;
    private List<MealDto> meals;
}
