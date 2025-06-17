package com.ez.crm.module.client.core.entity;

import com.ez.crm.common.core.entity.BaseEntity;
import com.ez.crm.module.client.core.enums.LanguageEnum;
import com.ez.crm.module.client.core.enums.LeadApprovalEnum;
import com.ez.crm.module.client.core.enums.StageEnum;
import com.ez.crm.module.client.core.enums.VerificationEnum;
import com.ez.crm.module.client.util.MetadataConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity(name="client")
@Data
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String currency;

    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0")
    private Double balance = 0.0;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean tradingEnabled;

    private Integer stage;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer participationCount;

    @Column(name = "language", nullable = false)
    private String language;

    private Integer leadApproval;

    private Integer verification;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastAccessUtc;

    @Convert(converter = MetadataConverter.class)
    @Column(columnDefinition = "json")
    private Map<String, String> metadata;

}
