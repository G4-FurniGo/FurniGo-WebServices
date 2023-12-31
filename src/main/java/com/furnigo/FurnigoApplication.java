package com.furnigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FurnigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnigoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**")
                        .allowedOrigins("http://localhost:4200") // Reemplaza con el origen de tu aplicación Angular
                        .allowedMethods("*")
                        .allowedHeaders("Authorization", "Content-Type")
                        .allowCredentials(true);
            };
        };
    }
}
