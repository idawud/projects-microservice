package io.turntable.projectwebservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.models.Project;
import io.turntable.projectwebservice.services.ProjectDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Api
@RestController
public class ProjectController {

    @Autowired
    private ProjectDAOImpl projectDAO;

    @ApiOperation("get all projects")
    @RequestMapping("/project")
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @ApiOperation("get project by name")
    @RequestMapping("/project/search/{name}")
//    public List<Project> getAllProjectByName(@RequestParam(name = "name", defaultValue = "---") String name) {
    public List<Project> getAllProjectByName(@PathVariable String name) {
        return projectDAO.getProjectByName(name);
    }

    @ApiOperation("add new project")
    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public void addProject(@RequestBody Project project) {
        projectDAO.addProject(project);
    }
//    @PostMapping(value = "/customer/create", consumes = "application/json", produces = "application/json")
//    public Customer addNewCustomer(
//            @RequestBody Customer customer
//    ){
//        //redisMessagePublisherUpdates.publish(customer);
//        return dao.addNewCustomer(customer);
//    }

    @ApiOperation("delete project")
    @RequestMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectDAO.deleteProject(id);
    }


}
