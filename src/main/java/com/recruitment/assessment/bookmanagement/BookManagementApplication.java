package com.recruitment.assessment.bookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.recruitment.assessment.bookmanagement")
@EnableJpaRepositories("com.recruitment.assessment.bookmanagement.repository")
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
	}

}
