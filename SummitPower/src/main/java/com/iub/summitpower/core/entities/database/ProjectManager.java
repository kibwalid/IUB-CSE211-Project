package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.core.entities.fucntional.Task;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProjectManager extends BaseUser {

    public final static String ENTITY_NAME = "ProjectManager";

    private List<WorkHistory> workHistory;
    private double salary;
    private List<Message> messages;
    private List<Project> projects;
    private List<Task> tasks;

    public ProjectManager() {
        super();
    }

    public ProjectManager(int id, String name, String username, String password, String email, String phoneNumber, String position, List<WorkHistory> workHistory, double salary, List<Message> messages, List<Project> projects, List<Task> tasks) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, UserType.PROJECT_MANAGER);
        this.workHistory = workHistory;
        this.salary = salary;
        this.messages = messages;
        this.projects = projects;
        this.tasks = tasks;
    }

    @Override
    public String getWorkHistoryAsText() {
        StringBuilder text = new StringBuilder();
        for (WorkHistory work : this.workHistory) {
            text.append(work.getWork()).append(" - ").append(work.getAddedAt().format(DateTimeFormatter.ISO_DATE)).append("\n");
        }
        return text.toString();
    }

    @Override
    public String getPersonalInformation() {
        return this.getName() + " (" + this.getPosition() + ") \n"
                + this.getUserType() + "\n" + "Salary : " + this.getSalary() + "\n---------\n"
                + "Phone : " + this.getPhoneNumber() + "\n"
                + "Email : " + this.getEmail() + "\n";
    }

    public List<WorkHistory> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<WorkHistory> workHistory) {
        this.workHistory = workHistory;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
