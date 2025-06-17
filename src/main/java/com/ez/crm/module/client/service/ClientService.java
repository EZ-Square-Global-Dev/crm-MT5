package com.ez.crm.module.client.service;

import com.ez.crm.common.core.response.PageResponse;
import com.ez.crm.module.client.core.dto.request.ClientCreateRequest;
import com.ez.crm.module.client.core.dto.request.ClientGetAllRequest;
import com.ez.crm.module.client.core.dto.request.ClientUpdateRequest;
import com.ez.crm.module.client.core.dto.response.ClientResponse;
import com.ez.crm.module.client.core.entity.ClientEntity;

import java.util.List;

public interface ClientService {

    ClientResponse getById(Long id);

    ClientResponse create(ClientCreateRequest createClient);

    void delete(Long id);

    ClientResponse patch(Long id, ClientUpdateRequest request);

    PageResponse<ClientResponse> getAllClientsFiltered(ClientGetAllRequest request);

}
