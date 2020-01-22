package br.com.survival;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import br.com.survival.core.security.SurvivalApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(SurvivalApiProperty.class)
public class SurvivalApiApplication {
	
	private static ApplicationContext APPLICATION_CONTEXT;

	public static void main(String[] args) {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	    APPLICATION_CONTEXT = SpringApplication.run(SurvivalApiApplication.class, args);
	}
	
	public static <T> T getBean(Class<T> type) {
            return APPLICATION_CONTEXT.getBean(type);
        }

}
