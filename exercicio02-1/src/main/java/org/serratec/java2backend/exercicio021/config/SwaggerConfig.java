package org.serratec.java2backend.exercicio021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("org.serratec.java2backend.exercicio021.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
		.title ("API de Teste")
		.description ("Essa é uma API desenvolvida para testes diversos")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
		.termsOfServiceUrl("/service.html")
		.version("1.0.0")
		.contact(new Contact("Pedro Coelho", "https://github.com/PedroHQCoelho", "pedrohqcoelho@gmail.com"))
		.build();
		return apiInfo;
	}
}
