package com.sda.securityproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/sign-up").setViewName("signup");
        registry.addViewController("/sign-in").setViewName("signin");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/added").setViewName("added");

    }
}
