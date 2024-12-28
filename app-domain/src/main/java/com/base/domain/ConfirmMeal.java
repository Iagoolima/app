package com.base.domain;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class ConfirmMeal{

    private Integer idMeal;

    private LocalTime timer;

    private List<ConfirmItemMeal> items;
}
