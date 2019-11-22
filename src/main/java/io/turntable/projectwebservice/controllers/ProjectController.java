package io.turntable.projectwebservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntable.projectwebservice.DomainTO.Project;
import io.turntable.projectwebservice.serviceImplementors.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Api
@RestController
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @ApiOperation("get all projects")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping({"/project", "/"})
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }


    @ApiOperation("get project by name")
    @GetMapping("/project/search/name/{name}")
    public Optional<List<Project>> getAllProjectByName(@PathVariable String name) {
        return projectService.getProjectByName(name);
    }


    @ApiOperation("add new project")
    @PostMapping("/project/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addProject(@RequestBody Map<String, String> jsonRequest) {
        projectService.addProject(jsonRequest);
        System.out.println("new project added successfully");
    }


    @ApiOperation("delete project")
    @DeleteMapping("/project/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }


    @ApiOperation("update existing project")
    @PutMapping("/project/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProjectRecord(@PathVariable String id, @RequestBody Map<String, String> requestBody) {
        Project result = projectService.getProjectById(id);
        result.setProject_name(requestBody.get("project_name"));
        result.setDescription(requestBody.get("description"));
        projectService.updateProject(result);
        System.out.println("project with id = " + id + " updated successfully");
    }


    @ApiOperation("get project by id")
    @GetMapping("/project/search/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable String id) {
       return projectService.getProjectById(id);
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



/*
* NB
* @RequestMapping("/project/searchId/{id}") .... provides many controller verbs at Swagger-UI
* */
