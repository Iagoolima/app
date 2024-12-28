package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "restricao_nutricional")
public class Restriction extends EntityID {

    private String name;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }
}
