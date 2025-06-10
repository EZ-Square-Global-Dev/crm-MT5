package com.ez.crm.config.configProperty;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@Setter
@ConfigurationProperties(prefix = "thread-pool")
public class AsyncConfigProperty {

    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private String threadNamePrefix;

}
