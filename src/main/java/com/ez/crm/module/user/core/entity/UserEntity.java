package com.ez.crm.module.user.core.entity;

import com.ez.crm.common.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class UserEntity  extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    public UserEntity(String name) {
        this.id = 1L;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
