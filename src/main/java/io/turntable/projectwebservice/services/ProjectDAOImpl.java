package io.turntable.projectwebservice.services;

import io.turntable.projectwebservice.models.Project;
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
        System.out.println("project added successfully");
    }



    @Override
    public void deleteProject(String projectID) {
//        Integer projectID = Integer.parseInt(projectID);
        jdbcTemplate.update("delete from projects where project_id = ?", new Object[]{projectID});
        System.out.println("project with id = " + projectID + "deleted successfully");
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
