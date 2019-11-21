package io.turntable.projectwebservice.models;

public class Project {

    private int project_id;
    private String project_name;
    private String description;

    public Project() {
    }

    public Project(int project_id, String project_name, String description) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.description = description;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
