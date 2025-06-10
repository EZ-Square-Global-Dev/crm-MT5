package com.ez.crm.module.user.controller;

import com.ez.crm.common.core.constant.ApiURL;
import com.ez.crm.common.core.exception.BadRequestException;
import com.ez.crm.common.core.response.ApiResponse;
import com.ez.crm.module.user.core.entity.UserEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(ApiURL.API_USER)
public class UserController {

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID" )
    public ApiResponse<UserEntity> getUser(@PathVariable Long id) {
        if(id == 1) {
            throw new BadRequestException("bad request");
        }
        return ApiResponse.ok(new UserEntity("huy 1"));
    }
}

