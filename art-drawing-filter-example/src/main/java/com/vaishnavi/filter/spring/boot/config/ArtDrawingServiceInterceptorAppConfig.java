package com.vaishnavi.filter.spring.boot.config;

import com.vaishnavi.filter.spring.boot.interceptor.ArtDrawingServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ArtDrawingServiceInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private ArtDrawingServiceInterceptor artDrawingServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(artDrawingServiceInterceptor);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/artdrawing").allowedOrigins("http://localhost:8080");
            }
        };
    }
}


