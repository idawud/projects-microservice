package io.turntable.projectwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ProjectWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebserviceApplication.class, args);
	}

	@Bean
	public JdbcTemplate getJdbcTemp(){
		return new JdbcTemplate();
	}
}
