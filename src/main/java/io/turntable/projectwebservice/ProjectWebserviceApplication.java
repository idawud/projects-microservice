package io.turntable.projectwebservice;

import io.turntable.projectwebservice.models.Project;
import io.turntable.projectwebservice.services.ProjectDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProjectWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebserviceApplication.class, args);
	}

	@Bean
	public ProjectDAOImpl getProjectDAO(){
		return new ProjectDAOImpl();
	}

	@Bean
	public Project getProject(){return new Project();}

//	@Bean
//	public Project getProjectBean(){return new Project();}
}
