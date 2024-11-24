package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "plano_de_refeicao")
public class MealPlan extends EntityID {

    @ManyToOne
    @JoinColumn(name = "profile_nutrition_id", nullable = false)
    private ProfileNutrition profileNutrition;

    private int totalCalories;

    @OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meal> meals;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
}
