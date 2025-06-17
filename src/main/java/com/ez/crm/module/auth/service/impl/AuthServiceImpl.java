package com.ez.crm.module.auth.service.impl;

import com.ez.crm.common.core.exception.AuthorizationException;
import com.ez.crm.common.core.exception.NotFoundException;
import com.ez.crm.module.auth.core.view.ClientAuthView;
import com.ez.crm.module.auth.dto.request.AuthRequest;
import com.ez.crm.module.auth.dto.response.AuthResponse;
import com.ez.crm.module.auth.service.AuthService;
import com.ez.crm.module.auth.util.JwtUtil;
import com.ez.crm.module.client.core.entity.ClientEntity;
import com.ez.crm.module.client.repository.ClientRepository;
import com.ez.crm.module.client.service.ClientService;
import com.ez.crm.module.client.util.ClientUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;
    private final ClientRepository clientRepository ;

    public AuthServiceImpl(ClientRepository clientRepository,JwtUtil jwtUtil){
        this.clientRepository = clientRepository;
        this.jwtUtil = jwtUtil;
    }

   public AuthResponse login(AuthRequest request){

       ClientAuthView client = clientRepository.findAuthByEmail(request.getEmail())
               .orElseThrow(() -> new NotFoundException("Invalid credentials"));

       String hashedInputPassword = ClientUtil.sha256(request.getPassword());

       if (!hashedInputPassword.equals(client.getPassword())) {
           throw new AuthorizationException("Invalid credentials");
       }
       String token = jwtUtil.generateToken(request.getEmail());

       // update last access
       clientRepository.updateLastAccess(client.getId(),LocalDateTime.now());

       return new AuthResponse( client.getEmail(), token);

    }
}
