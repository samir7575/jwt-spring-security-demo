package com.softdesign;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JwtSpringSecurityDemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JwtSpringSecurityDemoApplication.class, args);
	}

	@Bean
	ApiInfo apiInfo()
	{
		ApiInfo apiInfo = new ApiInfo(
				"Mikzo REST API",
				"",
				"2.2.2",
				"",
				"",
				"",
				"");
		return apiInfo;
	}

	@Bean
	public Docket customImplementation()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude Spring error controllers
				.build();
	}
}
