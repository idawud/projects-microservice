package io.turntable.projectwebservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.Models.Project;
import io.turntable.projectwebservice.serviceImplementors.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation("get all projects")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping({"/project", "/"})
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @CrossOrigin
    @ApiOperation("get project by name")
    @GetMapping("/project/search/name/{name}")
    public Optional<List<Project>> getAllProjectByName(@PathVariable String name) {
        return projectService.getProjectByName(name);
    }

    @CrossOrigin
    @ApiOperation("add new project")
    @PostMapping("/project/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProject(@RequestBody Project project) {
        projectService.addProject(project);
    }

    @CrossOrigin
    @ApiOperation("delete project")
    @DeleteMapping("/project/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    @CrossOrigin
    @ApiOperation("update existing project")
    @PutMapping("/project/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProjectRecord(@PathVariable String id, @RequestBody Project project) {
        Project projectToUpdate = projectService.getProjectById(id);
        projectToUpdate.setProject_name(project.getProject_name());
        projectToUpdate.setDescription(project.getDescription());
        projectService.updateProject(projectToUpdate);
    }

    @CrossOrigin
    @ApiOperation("get project by id")
    @GetMapping("/project/search/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable String id) {
       return projectService.getProjectById(id);
    }
}





/*
* NB
* @RequestMapping("/project/searchId/{id}") .... provides many controller verbs at Swagger-UI
* getProjectById() is needed for update
* */
