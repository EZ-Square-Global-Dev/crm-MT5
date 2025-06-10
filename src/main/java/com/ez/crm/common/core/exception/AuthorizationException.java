package com.ez.crm.common.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "You are forbidden to perform this operation")
public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String message) {
        super(message);

    }
}
