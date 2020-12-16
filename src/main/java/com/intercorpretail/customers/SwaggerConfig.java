package com.intercorpretail.customers;

import com.google.common.base.Predicates;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(appinfo()).select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
    }

    private ApiInfo appinfo() {
        return new ApiInfoBuilder().title("Customers Application API")
                .description("An application that stores and lists customers")
                .version("v1.0").build();
    }
}
