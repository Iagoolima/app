package com.base.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemMeal {

    @JsonProperty("food")
    private String food;

    @JsonProperty("calories")
    private int calories;

    @JsonProperty("details")
    private String details;

    @JsonProperty("id")
    private int id;

    @JsonProperty("quantity")
    private String quantity;

}
