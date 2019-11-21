package io.turntable.projectwebservice.models;

public class Project {
    private int projectID;
    private int description;

    public Project() {
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
