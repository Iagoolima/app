package com.base.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class RegisterProfileNutritionDtoRequest {

    @NotNull(message = "O gênero não pode ser nulo.")
    @Pattern(regexp = "^[MF]$", message = "O gênero deve ser 'M' para masculino ou 'F' para feminino.")
    private String gender;

    @NotNull(message = "A idade não pode ser nula.")
    @Min(value = 12, message = "A idade deve ser maior que 11 anos.")
    private Integer age;

    @NotNull(message = "A altura não pode ser nula.")
    @Min(value = 91, message = "A altura deve ser maior que 90 cm.")
    private Integer height;

    @NotNull(message = "O peso não pode ser nulo.")
    @Min(value = 36, message = "O peso deve ser maior que 35 kg.")
    private Integer weight;

    @NotNull(message = "O peso desejado não pode ser nulo.")
    @Min(value = 36, message = "O peso deve ser maior que 35 kg.")
    private Integer desiredWeight;

    @NotNull(message = "O foco não pode ser nulo.")
    @Min(value = 0, message = "Código de foco nutricional incorreto.")
    private Integer focus;

    @NotNull(message = "As restrições não podem ser nulas.")
    private List<Integer> restrictions;

}
