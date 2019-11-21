package io.turntable.projectwebservice.services;

import io.turntable.projectwebservice.models.Project;

import java.util.List;

public interface ProjectDAO {
    void addProject(Project project);
    List<Project> getAllProject();
//    List<Project> getProjectByName(String productName);
//    void deleteProject(String productID);

}
