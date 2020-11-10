package com.revature.cart;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RibbonClient(name = "rss-cart-service")
public class RevatureCartBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevatureCartBackendApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.revature.cart.controller"))
				.build()
				.apiInfo(ApiDetails());
	}
	
	private ApiInfo ApiDetails() {
		return new ApiInfo(
				"Shopping Cart API",
				"Revature Swag Shop Shopping Cart",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Revature", "https://revature.com", "info@revature.com"),
				"API License",
				"https://revature.com",
				Collections.emptyList());
	}
}
