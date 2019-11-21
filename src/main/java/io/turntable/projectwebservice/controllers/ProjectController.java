package io.turntable.projectwebservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.models.Project;
import io.turntable.projectwebservice.ServiceImplementors.ProjectDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api
@RestController
public class ProjectController {

    @Autowired
    private ProjectDAOImpl projectDAO;

    @ApiOperation("get all projects")
//    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping({"/project", "/"})
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
    @PostMapping("/project/add")
    public void addProject(@RequestBody Map<String, String> jsonRequest) {
        projectDAO.addProject(jsonRequest);
    }

    @ApiOperation("delete project")
    @DeleteMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectDAO.deleteProject(id);
    }


}
