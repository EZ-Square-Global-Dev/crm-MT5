package com.ez.crm.module.client.controller;

import com.ez.crm.common.core.constant.ApiURL;
import com.ez.crm.common.core.response.ApiResponse;
import com.ez.crm.common.core.response.PageResponse;
import com.ez.crm.module.client.core.dto.request.ClientCreateRequest;
import com.ez.crm.module.client.core.dto.request.ClientGetAllRequest;
import com.ez.crm.module.client.core.dto.request.ClientUpdateRequest;
import com.ez.crm.module.client.core.dto.response.ClientResponse;

import com.ez.crm.module.client.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(ApiURL.API_CLIENT)
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public ApiResponse<ClientResponse> getUser(@PathVariable Long id) {
        ClientResponse result = this.clientService.getById(id);
        return ApiResponse.ok(result);
    }

    @PostMapping("/register")
    public ApiResponse<ClientResponse> create(@RequestBody @Valid ClientCreateRequest request) {
        ClientResponse result = this.clientService.create(request);
        return ApiResponse.ok(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by ID")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        this.clientService.delete(id);
        return ApiResponse.ok();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Partially update client")
    public ApiResponse<ClientResponse> patchClient(@PathVariable Long id,
                                                   @RequestBody ClientUpdateRequest request) {
        ClientResponse result = clientService.patch(id, request);
        return ApiResponse.ok(result);
    }

    @GetMapping("")
    @Operation(summary = "Get all clients with filter and pagination")
    public ApiResponse<PageResponse<ClientResponse>> getClients(@ParameterObject @ModelAttribute ClientGetAllRequest filter) {
        PageResponse<ClientResponse> clients = clientService.getAllClientsFiltered(filter);
        return ApiResponse.ok(clients);
    }

}

