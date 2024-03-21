package com.binde.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(
//				title = "The UBA Banking Application",
//				description = "Backend Rest APIs for UBA Bank",
//				version = "v1.0",
//				contact = @Contact(
//						name = "Nannim Binde",
//						email = "nannimbinde@gmail.com",
//						url = "https://github.com/binde318/uba_bank"
//
//				),
//				license = @License(
//						name = "The Binde Java Academy",
//						url = "https://github.com/binde318/uba_bank"
//				)
//
//		),
//		externalDocs = @ExternalDocumentation(
//				description = "UBA Banking Application Documentation",
//				url = "https://github.com/binde318/uba_bank"
//
//		)
//)
public class BankApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankApplication.class, args);
	}

}
