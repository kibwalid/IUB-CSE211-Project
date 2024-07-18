package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.util.List;

public class HRExecutive extends BaseUser {

    public final static String ENTITY_NAME = "HRExecutive";

    private List<WorkHistory> workHistory;
    private double salary;
    private List<Message> messages;

    public HRExecutive() {
        super();
    }

    public HRExecutive(int id, String name, String username, String password, String email, String phoneNumber, String position, UserType userType, List<WorkHistory> workHistory, double salary, List<Message> messages) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, userType);
        this.workHistory = workHistory;
        this.salary = salary;
        this.messages = messages;
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
