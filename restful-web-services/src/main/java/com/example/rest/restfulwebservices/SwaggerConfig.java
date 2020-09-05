package com.example.rest.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
//@EnableSwagger2 no need from swagger v3
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Harikesh", "http://harikesh409.github.io/",
			"p.harikesh409@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Api Documentation Description",
			"1.0", "", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_CONSUMES)
				.consumes(DEFAULT_PRODUCES_CONSUMES)
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()));
	}
	
	private BasicAuth securityScheme() {
	    return new BasicAuth("basicAuth");
	}

	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	            .securityReferences(Arrays.asList(basicAuthReference()))
	            .forPaths(PathSelectors.any())
	            .build();
	}
	
	private SecurityReference basicAuthReference() {
	    return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	}
}
