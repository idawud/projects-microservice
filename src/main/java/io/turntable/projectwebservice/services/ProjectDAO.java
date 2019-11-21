package io.turntable.projectwebservice.services;

import io.turntable.projectwebservice.models.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDAO {
    List<Project> getAllProjects();
    List<Project> getProjectByName(String productName);
    void deleteProject(String productID);
    void addProject(Map<String, String> jsonRequest);
    void updateProject(Project project);
}
