package io.turntable.projectwebservice.serviceImplementors;

import io.turntable.projectwebservice.DTO.Project;
import io.turntable.projectwebservice.services.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class ProjectDAOImpl implements ProjectDAO {

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
    public List<Project> getProjectByName(String productName) {
        List<Project> projects = jdbcTemplate.query("select * from projects where project_name like ?",
                new Object[]{"%" + productName.toLowerCase() + "%"},
                BeanPropertyRowMapper.newInstance(Project.class));
        return projects;
    }

    @Override
    public void addProject(Map<String, String> jsonRequest) {
        jdbcTemplate.update("insert into projects (project_name, description) values (?, ?)",
                new Object[]{jsonRequest.get("project_name"),jsonRequest.get("description")}
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

}
