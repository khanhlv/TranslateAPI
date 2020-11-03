package com.translate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    private static Set<String> producesAndConsumes = new HashSet<>(Arrays.asList("application/json"));

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("X-TOKEN-AUTH", authorizationScopes));
    }

    private SecurityContext securityContext() {
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    @Bean
    public Docket api() {

        LOGGER.debug("Starting Swagger");

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(producesAndConsumes)
                .consumes(producesAndConsumes)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.translate.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(new ApiKey("X-TOKEN-AUTH", "X-TOKEN-AUTH", "header")))
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API",
                "List API of project (Android & iOS).",
                "1.0",
                "http://#",
                new Contact("KhanhLV", "http://#", "khanhlv.group1@gmail.com"),
                "License of API", "http://#", Collections.emptyList());
    }
}
