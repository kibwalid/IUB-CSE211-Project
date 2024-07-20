package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Issues;
import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.time.format.DateTimeFormatter;
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

    public QualityAssuranceTester(int id, String name, String username, String password, String email, String phoneNumber, String position, double salary, List<Issues> assignedIssues, List<WorkHistory> workHistory, List<Message> messages) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, UserType.QUALITY_ASSURANCE_TESTER);
        this.salary = salary;
        this.assignedIssues = assignedIssues;
        this.workHistory = workHistory;
        this.messages = messages;
    }

    @Override
    public String getPersonalInformation() {
        return this.getName() + " (" + this.getPosition() + ") \n"
                + this.getUserType() + "\n" + "Salary : " + this.getSalary() + "\n---------\n"
                + "Phone : " + this.getPhoneNumber() + "\n"
                + "Email : " + this.getEmail() + "\n";
    }

    @Override
    public String getWorkHistoryAsText() {
        StringBuilder text = new StringBuilder();
        for (WorkHistory work : this.workHistory) {
            text.append(work.getWork()).append(" - ").append(work.getAddedAt().format(DateTimeFormatter.ISO_DATE)).append("\n");
        }
        return text.toString();
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
