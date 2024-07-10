package com.bizweb.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "error")
@Getter
@Setter
public class ErrorCodeConfig {
	private int unauthorized;
	private int forbidden;
	private int notFoundCode;
	private int serverErrorCode;
	private String notFoundMessage;
	private String serverErrorMessage;
}
