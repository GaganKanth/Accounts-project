package com.restart.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

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
@EnableMongoAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
