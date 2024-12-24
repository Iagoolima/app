package com.base.constants;

import org.springframework.stereotype.Component;

@Component
public class MealPlanConstants {

    public final String errorGenerateMealPlan = "Erro ao gerar plano alimentar";
    public final String valueNullMealPlan = "Plano alimentar contém valores nulos";

    public final String errorFindMeal = "Erro ao consultar refeicao";
    public final String errorFindMealPlan = "Erro ao consultar plano de refeição";

    public final String errorEqualsValueMealPlan = "Plano de refeição não são iguais";
    public final String errorInvalidTime = "Refeição: {0} com hora inserida: {1}, precisa estar entre o intervalo de {2} e {3}.";

    public final String errorFilterMappingMeal =  "Item referente ao mapeamento não encontrado";
    public final String errorFilterMeal = "Refeição não encontrada";

    public final String mealPlanCompleted = "Plano de refeição já finalizado";
}
