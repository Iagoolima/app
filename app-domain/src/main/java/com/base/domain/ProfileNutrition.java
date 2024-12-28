package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "perfil_nutricional")
public class ProfileNutrition extends EntityID {

    private char gender;

    private int age;

    private int height;

    private int weight;

    private int desiredWeight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_focus", referencedColumnName = "id")
    private Focus focus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "perfil_nutricional_restricoes",
            joinColumns = @JoinColumn(name = "profile_nutrition_id"),
            inverseJoinColumns = @JoinColumn(name = "restriction_id")
    )
    private List<Restriction> restrictions;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }

}
