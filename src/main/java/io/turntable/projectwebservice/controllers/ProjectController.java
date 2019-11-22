package io.turntable.projectwebservice.controllers;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.DTO.Project;
import io.turntable.projectwebservice.serviceImplementors.ProjectDAOImpl;
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
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping({"/project", "/"})
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @ApiOperation("get project by name")
    @RequestMapping("/project/search/{name}")
    public List<Project> getAllProjectByName(@PathVariable String name) {
        return projectDAO.getProjectByName(name);
    }

    @ApiOperation("add new project")
    @PostMapping("/project/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProject(@RequestBody Map<String, String> jsonRequest) {
        projectDAO.addProject(jsonRequest);
        System.out.println("new project added successfully");
    }

    @ApiOperation("delete project")
    @DeleteMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectDAO.deleteProject(id);
    }

    @ApiOperation("update existing project")
    @PutMapping("/project/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProjectRecord(@PathVariable String id, @RequestBody Map<String, String> requestBody) {

        System.out.println(requestBody.get("project_id"));
        System.out.println("body....." + requestBody);
//        projectDAO.updateProject();
    }


    //    @GetMapping()
    @RequestMapping("/project/searchId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable String id) {
       return projectDAO.getProjectById(id);
    }
}




/*
    todo: pass json as ooject
    @ApiOperation("add project")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/project/add", consumes = "application/json", produces = "application/java")
    public void addProject(@RequestBody Project project){
        projectDAO.updateProject(project);
        System.out.println("new project added successfully");
    }
*/

