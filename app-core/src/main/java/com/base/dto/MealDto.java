package com.base.dto;

import lombok.Data;

import java.util.List;

@Data
public class MealDto {

    private String mealName;
    private List<ItemMealDto> items;
}
