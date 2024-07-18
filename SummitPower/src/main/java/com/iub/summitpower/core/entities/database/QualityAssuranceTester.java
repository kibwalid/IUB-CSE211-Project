package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Issues;
import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.util.List;

public class QualityAssuranceTester extends BaseUser {
    public final static String ENTITY_NAME = "QualityAssuranceTester";


    private double salary;
    private List<Issues> assignedIssues;
    private List<WorkHistory> workHistory;
    private List<Message> messages;

    public QualityAssuranceTester() {
        super();
    }

    public QualityAssuranceTester(int id, String name, String username, String password, String email, String phoneNumber, String position, UserType userType, double salary, List<Issues> assignedIssues, List<WorkHistory> workHistory, List<Message> messages) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, userType);
        this.salary = salary;
        this.assignedIssues = assignedIssues;
        this.workHistory = workHistory;
        this.messages = messages;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Issues> getAssignedIssues() {
        return assignedIssues;
    }

    public void setAssignedIssues(List<Issues> assignedIssues) {
        this.assignedIssues = assignedIssues;
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