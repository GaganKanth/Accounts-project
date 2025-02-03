package com.restart.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.restart.accounts"})
@OpenAPIDefinition(
		info =@Info(
				version = "v1.0",
				description = "Accounts",
				title = "Accounts",
				contact = @Contact(
						email = "gagangaliveeti1234@gmail.com",
						url = "https:/8090/hi"
				),
				license = @License(
						name = "Gagan",
						url = "gagan//8090.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				url ="http:1999/2001.com",
				description = "Project"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
