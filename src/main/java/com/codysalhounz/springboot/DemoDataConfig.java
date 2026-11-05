package com.codysalhounz.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDataConfig {

	@Bean
	CommandLineRunner seedEmployees(EmployeeRepository employeeRepository) {
		return args -> {
			if (employeeRepository.count() == 0) {
				employeeRepository.save(new Employee("Ada Lovelace", "ada@example.com", "Engineering"));
				employeeRepository.save(new Employee("Grace Hopper", "grace@example.com", "Technology"));
			}
		};
	}
}
