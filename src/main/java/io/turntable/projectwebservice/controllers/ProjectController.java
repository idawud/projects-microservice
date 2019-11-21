package io.turntable.projectwebservice.controllers;

import io.turntable.projectwebservice.models.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @RequestMapping("/project")
    public Project getAllProject() {
        return null;
    }

    @RequestMapping("/project/{}")
    public Project getAllProjectByName() {
        return null;
    }


}
