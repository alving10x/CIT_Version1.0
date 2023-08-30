package com.projects.CIT_Version1_0;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://a4955f1b16ed44d038f52467528d851d-601365894.eu-west-2.elb.amazonaws.com")  // List your frontend origin(s) here
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowedHeaders("Access-Control-Allow-Origin","http://a4955f1b16ed44d038f52467528d851d-601365894.eu-west-2.elb.amazonaws.com");
//                .allowCredentials(true)
//                .allowCredentials(true).maxAge(3600);
    }
}
