package com.ez.crm.module.client.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private Long id;
    private String email;
    private String currency;
    private Double balance;
    private Boolean tradingEnabled;
    private String stage;
    private int participationCount;
    private String language;
    private String leadApproval;
    private String verification;
    private LocalDateTime lastAccessUtc;
    private LocalDateTime createUtc;
    private LocalDateTime updateUtc;
}

