package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.entities.database.Engineer;
import com.iub.summitpower.core.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public class Project extends BaseFunctional {

    public final static String ENTITY_NAME = "Project";

    public Project() {
        super();
    }

    public Project(int id, String name, String description, List<Task> tasks, List<Engineer> assignedEngineers, LocalDateTime deadline, double cost, Status status) {
        super(id, ENTITY_NAME);
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.assignedEngineers = assignedEngineers;
        this.deadline = deadline;
        this.status = status;
        this.cost = cost;
    }

    private String name;
    private String description;
    private List<Task> tasks;
    private List<Engineer> assignedEngineers;
    private LocalDateTime deadline;
    private Status status;
    private double cost;


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Engineer> getAssignedEngineers() {
        return assignedEngineers;
    }

    public void setAssignedEngineers(List<Engineer> assignedEngineers) {
        this.assignedEngineers = assignedEngineers;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean removeTask(Task task) {
        return this.tasks.remove(task);
    }

    public boolean addTask(Task task) {
        return this.tasks.add(task);
    }

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
