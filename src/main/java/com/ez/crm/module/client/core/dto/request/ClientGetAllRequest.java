package com.ez.crm.module.client.core.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class ClientGetAllRequest {
    @Schema(description = "Filter by email")
    private String email;

    @Schema(description = "Page number (starts from 1)", defaultValue = "1")
    private int page = 0;

    @Schema(description = "Items per page", defaultValue = "10")
    private int limit = 10;

    @Schema(description = "Sort property, e.g. email, id, balance", example = "email")
    private String sortBy = "id";

    @Schema(description = "Sort direction: asc or desc", example = "asc")
    private String sortDirection = "asc";
}
