package com.ez.crm.module.client.mapper;

import com.ez.crm.module.client.core.constant.LeadApprovalConstant;
import com.ez.crm.module.client.core.constant.StageConstant;
import com.ez.crm.module.client.core.constant.VerificationConstant;
import com.ez.crm.module.client.core.dto.response.ClientResponse;
import com.ez.crm.module.client.core.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "stage", target = "stage", qualifiedByName = "stageToString")
    @Mapping(source = "leadApproval", target = "leadApproval", qualifiedByName = "leadApprovalToString")
    @Mapping(source = "verification", target = "verification", qualifiedByName = "verificationToString")
    ClientResponse toResponse(ClientEntity entity);

    @Named("stageToString")
    default String stageToString(int stageCode) {
        return StageConstant.getStageName(stageCode);
    }

    @Named("leadApprovalToString")
    default String leadApprovalToString(int code ) {
        return LeadApprovalConstant.getLeadApprovalName(code);
    }

    @Named("verificationToString")
    default String verificationToString(int code ) {
        return VerificationConstant.getLeadVerifyName(code);
    }
}

