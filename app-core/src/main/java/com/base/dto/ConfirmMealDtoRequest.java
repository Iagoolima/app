package com.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class ConfirmMealDtoRequest{

    private Integer idMeal;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime timer;

    private List<ConfirmItemMealDtoRequest> items;

}
