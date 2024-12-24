package com.base.controller.impl;

import com.base.controller.BaseController;
import com.base.dto.ConfirmMealPlanDtoRequest;
import com.base.processor.MealPlanProcessor;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/meal-plan")
public class MealPlanController extends BaseController {

    @Autowired
    private MealPlanProcessor processor;

    @Operation(
            summary = "Gera um Plano alimentar",
            description = "Este endpoint gera um plano alimentar apartir do modulo de Inteligencia Artificial",
            tags = {"Module IA"}
    )
    @PostMapping("/generate")
    public ResponseEntity<?> generateMealPlan () {
        return processor.registerProcessor();
    }

    @Operation(
            summary = "Consulta item de alimentação para validar a refeição",
            description = "Este endpoint consulta todos os itens de alimentação referente a validação de refeição solicitada",
            tags = {"Plano de refeição"}
    )
    @GetMapping("/find-from-validate-meal/{id}")
    public ResponseEntity<?> findFromValidateMeal (@RequestParam Integer id) {
        return processor.findFromValidateMeal(id);
    }

    @Operation(
            summary = "Confirma as alimentações de cada refeição.",
            description = "Este endpoint envia os itens de alimentação com a hora.",
            tags = {"Plano de refeição"}
    )
    @PostMapping("/confirm-meal-plan")
    public ResponseEntity<?> confirmMealPlan ( @RequestBody @Valid ConfirmMealPlanDtoRequest dto) {
        return processor.confirmMealPlan(dto);
    }

}
