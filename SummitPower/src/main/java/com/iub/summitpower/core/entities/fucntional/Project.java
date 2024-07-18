package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.enums.Status;

public class Project extends BaseFunctional {

    public final static String ENTITY_NAME = "Project";

    public Project() {
        super();
    }

    public Project(int id, String name, String description, Status status) {
        super(id, ENTITY_NAME);
        this.name = name;
        this.description = description;
        this.status = status;
    }

    private String name;
    private String description;
    private Status status;
    // TODO:: create project later


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
