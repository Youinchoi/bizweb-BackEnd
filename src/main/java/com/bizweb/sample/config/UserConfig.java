package com.bizweb.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class UserConfig {
	private String registerSuccess;
    private String registerFailure;
    
    private String loginSuccess;
    private String loginFailure;
    
    private String updateSuccess;
    private String updateFailure;
    
    private String deleteSuccess;
    private String deleteFailure;
    
    private String withdrawalSuccess;
    private String withdrawalFailure;
}
