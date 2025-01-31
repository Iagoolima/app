package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "refeicao")
public class Meal extends EntityID {

    @ManyToOne
    @JoinColumn(name = "meal_plan_id", nullable = false)
    private MealPlan mealPlan;

    private String mealName;

    @ManyToOne
    @JoinColumn(name= "mapping_meal_id", nullable = false)
    private MappingMeal idMappingMeal;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemMeal> items;

    private LocalTime time;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
}
