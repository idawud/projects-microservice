package io.turntable.projectwebservice.services;

import io.turntable.projectwebservice.models.Project;

import java.util.List;

public interface ProjectDAO {
    List<Project> getAllProjects();
    List<Project> getProjectByName(String productName);
    void deleteProject(String productID);
    void addProject(Project project);
    void updateProject(Project project);
}
