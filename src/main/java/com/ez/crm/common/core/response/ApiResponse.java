package com.ez.crm.common.core.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private long timestamp;
    private int status;

    public ApiResponse(HttpStatus status) {
        this.status = status.value();
        this.success = status.is2xxSuccessful();
        this.timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public ApiResponse(HttpStatus status, T data) {
        this(status);
        this.data = data;
    }

    public ApiResponse(HttpStatus status, T data, String message) {
        this(status, data);
        this.message = message;
    }

    public ApiResponse(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>(HttpStatus.OK);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(HttpStatus.OK, data);
    }

    public static <T> ApiResponse<T> ok(T data, String message) {
        return new ApiResponse<>(HttpStatus.OK, data, message);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(HttpStatus.SERVICE_UNAVAILABLE, message);
    }

    public static <T> ApiResponse<T> error(HttpStatus status) {
        return new ApiResponse<>(status, StringUtils.EMPTY);
    }

    public static <T> ApiResponse<T> error(HttpStatus status, String message) {
        return new ApiResponse<>(status, message);
    }
}
