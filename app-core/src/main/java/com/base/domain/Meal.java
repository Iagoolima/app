package com.base.domain;

import lombok.Data;

import java.util.List;

@Data
public class Meal {

    private String mealName;
    private List<ItemMeal> items;
}
