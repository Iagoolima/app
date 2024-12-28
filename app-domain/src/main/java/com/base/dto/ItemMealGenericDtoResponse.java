package com.base.dto;

import lombok.Data;

@Data
public class ItemMealGenericDtoResponse {

    private Integer id;

    private String food;

    private Integer calories;

    private String details;

    private String quantity;
}
