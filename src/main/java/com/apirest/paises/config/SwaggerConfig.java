/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.paises.config;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Elton Julio
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    
    @Bean
    public Docket paisApi(){
    return new Docket(DocumentationType.SWAGGER_2 )
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.apirest.paises"))
    .paths(regex("/pais.*"))
    .build()
    .apiInfo(metaInfo()); 
    }
    


    private ApiInfo metaInfo() {
   
    ApiInfo apiInfo = new ApiInfo(
            "Paises API REST",
            "API REST que nos permite gerenciar informações dos paises",
            "1.0",
            "Terms of Service",
            new Contact("EltonnJulio","","eltonnjulio@gmail.com") ,
            "Apache License Version 2.0",
            "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
             
    );
      
    return apiInfo;
    
    }
       
}
