package com.ez.crm.common.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@MappedSuperclass
public class BaseEntity {

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createUtc;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateUtc;

    @PrePersist
    protected void onCreate() {
        if (createUtc == null) createUtc = LocalDateTime.now();
        if (updateUtc == null) updateUtc = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateUtc = LocalDateTime.now();
    }
}

