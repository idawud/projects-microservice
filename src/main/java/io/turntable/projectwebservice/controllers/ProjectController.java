package io.turntable.projectwebservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Api
@RestController
public class ProjectController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ApiOperation("get all projects")
    @RequestMapping("/project")
    public List<Project> getAllProjects() {
      List<Project> projects = jdbcTemplate.query();

        return projects;
    }

    @ApiOperation("get project by name")
    @RequestMapping("/project/name")
    public Project getAllProjectByName(@RequestParam(name = "name", defaultValue = "") String name) {

        return null;
    }


}
