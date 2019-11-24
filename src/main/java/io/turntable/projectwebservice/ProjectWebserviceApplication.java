package io.turntable.projectwebservice;

import io.turntable.projectwebservice.serviceImplementors.ProjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProjectWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebserviceApplication.class, args);

	}

	@Bean
	public ProjectServiceImpl getProjectService(){
		return new ProjectServiceImpl();
	}

}
