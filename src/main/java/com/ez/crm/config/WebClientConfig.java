package com.ez.crm.config;

import com.ez.crm.intergration.http.UrlConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(UrlConstant.MT5_URL)
                .build();
    }
}

