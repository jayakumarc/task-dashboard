package com.github.jayakumarc.taskdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaskDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskDashboardApplication.class, args);
	}

}
