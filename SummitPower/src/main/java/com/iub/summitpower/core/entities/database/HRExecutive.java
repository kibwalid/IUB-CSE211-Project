package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class HRExecutive extends BaseUser {

    public final static String ENTITY_NAME = "HRExecutive";

    private List<WorkHistory> workHistory;
    private double salary;
    private List<Message> messages;

    public HRExecutive() {
        super();
    }

    public HRExecutive(int id, String name, String username, String password, String email, String phoneNumber, String position, List<WorkHistory> workHistory, double salary, List<Message> messages) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, UserType.HR_EXECUTIVE);
        this.workHistory = workHistory;
        this.salary = salary;
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
}
