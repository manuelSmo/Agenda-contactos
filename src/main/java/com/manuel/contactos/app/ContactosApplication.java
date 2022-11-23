package com.manuel.contactos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.manuel.contactos"})
@EntityScan(basePackages = {"com.manuel.contactos.model"})
@EnableJpaRepositories(basePackages = {"com.manuel.contactos.dao.repository"})
public class ContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactosApplication.class, args);
	}

}
