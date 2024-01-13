package com.vizz.Tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"com.vizz.Tasks.controller", "com.vizz.Tasks.model", "com.vizz.Tasks.repository", "com.vizz.Tasks.service", "com.vizz.Tasks.config"})
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}
