package br.com.survival.core.openapi;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.classmate.TypeResolver;

import br.com.survival.api.controller.exceptionhandler.ApiError;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket apiDocket() {
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.survival.api"))
					.paths(PathSelectors.any())
					.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, globalGetResponseMessage())
				.globalResponseMessage(RequestMethod.POST, globalPostAndPutResponseMessage())
				.globalResponseMessage(RequestMethod.PUT, globalPostAndPutResponseMessage())
				.globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessage())
				.additionalModels(typeResolver.resolve(ApiError.class))
				.apiInfo(apiInfo())
				.tags(new Tag("Débitos", "Gerenciador de débitos por pessoa"),
					  new Tag("Score", "Gerenciador de score de crédito por pessoa"),
					  new Tag("Eventos", "Gerenciador de eventos financeiros registrados por pessoa"));
	}
	
	private List<ResponseMessage> globalGetResponseMessage() {
		return Arrays.asList(
					new ResponseMessageBuilder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Erro interno do servidor")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.NOT_ACCEPTABLE.value())
						.message("Recurso não possuí representação que poderia ser aceita pelo consumidor")
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.UNAUTHORIZED.value())
						.message("Usuário sem permissão de acesso ao recurso solicitado")
						.build()
				);
	}
	
	private List<ResponseMessage> globalPostAndPutResponseMessage() {
		return Arrays.asList(
					new ResponseMessageBuilder()
						.code(HttpStatus.BAD_REQUEST.value())
						.message("Requisição inválida (erro do cliente)")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Erro interno do servidor")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.NOT_ACCEPTABLE.value())
						.message("Recurso não possuí representação que poderia ser aceita pelo consumidor")
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
						.message("Requisição recusada porque o corpo está em um formato não suportado")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.UNAUTHORIZED.value())
						.message("Usuário sem permissão de acesso ao recurso solicitado")
						.build()
				);
	}
	
	private List<ResponseMessage> globalDeleteResponseMessage() {
		return Arrays.asList(
					new ResponseMessageBuilder()
						.code(HttpStatus.BAD_REQUEST.value())
						.message("Requisição inválida (erro do cliente)")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message("Erro interno do servidor")
						.responseModel(new ModelRef("ApiError"))
						.build(),
					new ResponseMessageBuilder()
						.code(HttpStatus.UNAUTHORIZED.value())
						.message("Usuário sem permissão de acesso ao recurso solicitado")
						.build()
				);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Survival API")
				.description("API para controle e gestão de crédito")
				.version("1.0.0")
				.contact(new Contact("Jonathan Henrique Medeiros", "https://jonathanmdr.github.io/", "jonathan.mdr@hotmail.com"))
				.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
