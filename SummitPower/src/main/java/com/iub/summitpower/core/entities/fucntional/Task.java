package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.enums.Status;

import java.time.LocalDateTime;

public class Task extends BaseFunctional{

    public final static String ENTITY_NAME = "Task";


    public Task(int id, String taskName, String description, Status status, LocalDateTime deadline) {
        super(id, ENTITY_NAME);
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public Task(int id, String modelName, String taskName, String description, Status status, LocalDateTime deadline) {
        super(id, modelName);
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public Task() {
        super();
    }

    private String taskName;
    private String description;
    private Status status;

    private LocalDateTime deadline;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
