package com.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClassGeneric <T>{
    private T value;
}
