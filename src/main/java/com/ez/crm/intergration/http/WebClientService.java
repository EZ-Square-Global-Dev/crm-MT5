package com.ez.crm.intergration.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientService {

    @Autowired
    private WebClient webClient;

    public Mono<String> getExample() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class);
    }


    public Mono<String> createMT5Account(Object userDto) {
        return webClient.post()
                .uri("/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userDto)
                .retrieve()
                .bodyToMono(String.class);
    }
}
