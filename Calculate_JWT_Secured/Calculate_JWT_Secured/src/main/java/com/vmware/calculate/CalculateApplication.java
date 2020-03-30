package com.vmware.calculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class CalculateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.vmware.calculate"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo("Calculate Service Provider",
				"The purpose of this API is to provide " +
						"calculation services like addition " +
						"and subtraction to the authenticated users",
				"1.0","Info",
				new springfox.documentation.service.Contact("Calculate Service", "http://calculate.web.service.com", "calculateservice@calculate.service.com" ),
				"NA",
				"NA",
				new ArrayList<>());
	}
}
