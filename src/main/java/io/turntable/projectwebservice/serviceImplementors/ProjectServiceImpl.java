package io.turntable.projectwebservice.serviceImplementors;

import io.turntable.projectwebservice.DomainTO.Project;
import io.turntable.projectwebservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = jdbcTemplate.query("Select * from projects",
                BeanPropertyRowMapper.newInstance(Project.class));
        System.out.println("record retrieved successfully");
        return projects;
    }

    @Override
    public Optional<List<Project>> getProjectByName(String productName) {
        Optional<List<Project>> projects = Optional.ofNullable(jdbcTemplate.query("select * from projects where project_name like ?",
                new Object[]{"%" + productName.toLowerCase() + "%"},
                BeanPropertyRowMapper.newInstance(Project.class)));
        return projects;
    }

    @Override
    public void addProject(Project project) {
        System.out.println("...inside add service" + project);
        jdbcTemplate.update("insert into projects (project_name, description) values (?, ?)",
                new Object[]{project.getProject_name(), project.getDescription()}
        );
        System.out.println("new project added successfully");
    }

    @Override
    public void deleteProject(String projectId) {
        int pId = Integer.parseInt(projectId);
        jdbcTemplate.update("delete from projects where project_id = ?", new Object[]{pId});
        System.out.println("project with id = " + pId + " deleted successfully");
    }

    @Override
    public void updateProject(Project project) {
        this.jdbcTemplate.update(
                "update projects set project_name = ?, description = ? where project_id = ?",
                project.getProject_name(),
                project.getDescription(),
                project.getProject_id());
    }

    public Project getProjectById(String id) {
        int intId = Integer.parseInt(id);
        Project project = (Project) jdbcTemplate.queryForObject("select * from projects where project_id = ?",
                new Object[]{intId},
                BeanPropertyRowMapper.newInstance(Project.class)
        );
        System.out.println("got project id = " + id + " successfully");
                return project;
    }
}

// TODO: 11/22/19 :: code refactor
// TODO: 11/22/19 :: parse json as DAO to db
/*
        @Override
    public void addProject(Project project) {
        jdbcTemplate.update("insert into projects (project_name, description) values (?, ?)",
                new Object[]{project.getProject_name(),project.getDescription()});
        System.out.println("new project added successfully");}
*/
