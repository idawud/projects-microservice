package io.turntable.projectwebservice.controllers;

import io.turntable.projectwebservice.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private JdbcTemplate jdbcTemp;

    public JdbcTemplate getJdbcTemp() {
        return jdbcTemp;
    }

    public void setJdbcTemp(JdbcTemplate jdbcTemp) {
        this.jdbcTemp = jdbcTemp;
    }

    @RequestMapping("/{projectID}")
    public List<Project> getAllProjectsByID(@PathVariable("projectID") String projectID) {
        Project project = new Project();
        project.setProjectID(Integer.parseInt(projectID));
        project.setProjectName("tcms");
        project.setDescription("huuuu");

        return Collections.singletonList(project);
    }

    @RequestMapping("/project/{}")
    public Project getAllProjectByName() {
        return null;
    }


}
