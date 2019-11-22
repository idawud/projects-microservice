package io.turntable.projectwebservice.services;

import io.turntable.projectwebservice.DTO.Project;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectDAO {
    List<Project> getAllProjects();
    Optional<List<Project>> getProjectByName(String productName);
    void deleteProject(String productID);
    void addProject(Map<String, String> jsonRequest);
    void updateProject(Project project);
}
