package com.api.prova.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket provaApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.prova"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Prova",
                "API REST prova.",
                "1.0",
                "Terms of Service",
                new Contact("Guilherme Kloss", "https://www.linkedin.com/in/guilherme-kloss-mendes-0076828a/",
                        "mendeskloss@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
	
	

}
