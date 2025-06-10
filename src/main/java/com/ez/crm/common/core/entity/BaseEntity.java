package com.ez.crm.common.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BaseEntity {
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
