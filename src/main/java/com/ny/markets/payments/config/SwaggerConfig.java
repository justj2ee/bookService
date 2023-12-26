package com.ny.markets.payments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Payment Service").select()
				.apis(RequestHandlerSelectors.basePackage("com.ny.markets.payments"))
				.paths(PathSelectors.regex("/book.*"))
				.build().apiInfo(apiInfoMetaData());
	}

	private ApiInfo apiInfoMetaData() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Payment Service")
				.description("API Endpoint Decoration")
				.termsOfServiceUrl("https://www.dataanalyticsinc.com")
				.contact(new Contact("Dev-Team", "https://www.dev-team.com/", "teppsiii@yahoo.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.contact("Thomas Epps 917-455-1604")
				.build();
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
