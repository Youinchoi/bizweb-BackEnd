package com.bizweb.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "response")
@Getter
@Setter
public class ResponseConfig {
    private String success;
    private String failure;
    }

