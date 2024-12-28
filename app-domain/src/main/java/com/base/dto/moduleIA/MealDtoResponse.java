package com.base.dto.moduleIA;

import lombok.Data;

import java.util.List;

@Data
public class MealDtoResponse {

    private Integer id;
    private String mealName;
    private List<ItemMealDto> items;
}
