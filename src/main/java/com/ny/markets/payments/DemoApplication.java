package com.ny.markets.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.ny.markets.payments.service.BookService;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(DemoApplication.class, args);
		
		BookService service = configurableApplicationContext.getBean(BookService.class);
		System.out.println("=======>"+service.getBook(1));
	}
	
	/*@Bean
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}
*/
}
