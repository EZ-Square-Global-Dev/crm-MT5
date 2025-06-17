package com.ez.crm.module.client.service.impl;

import com.ez.crm.common.core.exception.BadRequestException;
import com.ez.crm.common.core.exception.NotFoundException;
import com.ez.crm.common.core.response.PageResponse;
import com.ez.crm.module.client.core.constant.LeadApprovalConstant;
import com.ez.crm.module.client.core.constant.StageConstant;
import com.ez.crm.module.client.core.constant.VerificationConstant;
import com.ez.crm.module.client.core.dto.request.ClientCreateRequest;
import com.ez.crm.module.client.core.dto.request.ClientGetAllRequest;
import com.ez.crm.module.client.core.dto.request.ClientUpdateRequest;
import com.ez.crm.module.client.core.dto.response.ClientResponse;
import com.ez.crm.module.client.core.entity.ClientEntity;
import com.ez.crm.module.client.core.enums.LanguageEnum;
import com.ez.crm.module.client.mapper.ClientMapper;
import com.ez.crm.module.client.repository.ClientRepository;
import com.ez.crm.module.client.service.ClientService;
import com.ez.crm.module.client.util.ClientUtil;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientResponse getById(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found "));

        return clientMapper.toResponse(clientEntity);

    }

    @Override
    public ClientResponse create(ClientCreateRequest request) {
        boolean isDuplicate = clientRepository.existsByEmail(request.getEmail());
        if(isDuplicate) {
            throw new BadRequestException("Email already exist");
        }
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setEmail(request.getEmail());
        clientEntity.setPassword(ClientUtil.sha256(request.getPassword()));

        clientEntity.setCurrency("");
        clientEntity.setLanguage(LanguageEnum.En.getLabel());
        clientEntity.setBalance(0.0);
        clientEntity.setTradingEnabled(true);
        clientEntity.setParticipationCount(0);
        clientEntity.setStage(StageConstant.ACTIVE);
        clientEntity.setVerification(VerificationConstant.VERIFIED);
        clientEntity.setLeadApproval(LeadApprovalConstant.APPROVED);
        clientEntity.setLastAccessUtc(null);

        ClientEntity result = clientRepository.save(clientEntity);

        return clientMapper.toResponse(result);
    }

    @Override
    public void delete(Long id) {
        int deleted = clientRepository.deleteIfExists(id);
        if (deleted == 0) {
            throw new BadRequestException("Client not found");
        }
    }

    @Override
    public ClientResponse patch(Long id, ClientUpdateRequest request) {
        ClientEntity entity = clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Client not found"));

        if (request.getEmail() != null) {
            entity.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            entity.setPassword(ClientUtil.sha256(request.getPassword()));
        }
        if (request.getLanguage() != null) {
            entity.setLanguage(request.getLanguage().name());
        }
        if (request.getMetadata() != null) {
            entity.setMetadata(request.getMetadata());
        }

        clientRepository.save(entity);
        return clientMapper.toResponse(entity);
    }

    public PageResponse<ClientResponse> getAllClientsFiltered(ClientGetAllRequest request) {
        int pageIndex = Math.max(request.getPage() - 1, 0);

        Sort.Direction direction = request.getSortDirection().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageIndex, request.getLimit(), Sort.by(direction, request.getSortBy()));

        Page<ClientEntity> pageResult = clientRepository.findAllByEmail(request.getEmail(), pageable);

        List<ClientResponse> data = pageResult.getContent().stream()
                .map(clientMapper::toResponse)
                .toList();

        return new PageResponse<>(data, request.getPage(), request.getLimit(), pageResult.getTotalElements());
    }




}
