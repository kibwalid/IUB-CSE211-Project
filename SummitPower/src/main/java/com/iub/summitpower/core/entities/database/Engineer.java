package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.Task;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.util.List;

public class Engineer extends BaseUser {

    public final static String ENTITY_NAME = "Engineer";


    private double salary;
    private List<Task> assignedTasks;
    private List<WorkHistory> workHistory;
    private List<Message> messages;

    public Engineer() {
        super();
    }

    public Engineer(int id, String name, String username, String password, String email, String phoneNumber, String position, UserType userType, double salary, List<Task> assignedTasks, List<WorkHistory> workHistory, List<Message> messages) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, userType);
        this.salary = salary;
        this.assignedTasks = assignedTasks;
        this.workHistory = workHistory;
        this.messages = messages;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<WorkHistory> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<WorkHistory> workHistory) {
        this.workHistory = workHistory;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
