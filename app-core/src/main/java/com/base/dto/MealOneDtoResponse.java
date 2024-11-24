package com.base.dto;

import com.base.domain.ItemMeal;
import com.base.domain.MappingMeal;
import com.base.domain.MealPlan;
import lombok.Data;

import java.util.List;

@Data
public class MealOneDtoResponse {

    private String mealName;

    private MealPlan mealPlan;

    private List<ItemMeal> items;

    private MappingMeal mappingMeal;

}
