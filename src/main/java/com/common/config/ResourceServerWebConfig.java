package com.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.kopaxgroup.api.controller" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
    //
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//	    registry.addMapping("/**");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
			    .allowedOrigins("http://localhost:8081")
			    .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
			    .allowedHeaders("header1", "header2", "header3")
			    .exposedHeaders("header1", "header2")
			    .allowCredentials(false).maxAge(3600);
    }
}
