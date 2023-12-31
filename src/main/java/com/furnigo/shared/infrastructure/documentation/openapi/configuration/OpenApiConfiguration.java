package com.furnigo.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI FurnigoOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Furnigo API")
                        .description(
                                "RESTful API documentation for Furnigo web application.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .externalDocs(new ExternalDocumentation()
                        .description("Furnigo Wiki Documentation")
                        .url("https://www.example.com"));
    }
}