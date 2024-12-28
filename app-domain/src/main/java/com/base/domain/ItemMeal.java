package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item_refeicao")
public class ItemMeal extends EntityID {

    private String food;

    private int calories;

    private String details;

    private String quantity;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
}
