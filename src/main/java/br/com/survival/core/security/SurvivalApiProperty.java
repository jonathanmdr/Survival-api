package br.com.survival.core.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("survival")
public class SurvivalApiProperty {
	
    private String allowedOrigin = "http://localhost:8095";

}
