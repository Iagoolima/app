package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "mapeamento_refeicoes")
public class MappingMeal extends EntityID {

    @Column(length = 50)
    private String name;

    private LocalTime timerInit;

    private LocalTime timerEnd;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
}
