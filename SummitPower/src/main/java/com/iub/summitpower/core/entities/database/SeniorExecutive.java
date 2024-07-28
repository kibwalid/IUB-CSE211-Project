package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.enums.UserType;

import java.util.List;

public class SeniorExecutive extends BaseUser{

    public final static String ENTITY_NAME = "SeniorExecutive";

    private double salary;
    private List<Message> messages;

    public SeniorExecutive() {
        super();
    }

    public SeniorExecutive(int id, String name, String username, String password, String email, String phoneNumber, String position, double salary,
                           List<Message> messages) {
        super(id, SeniorExecutive.ENTITY_NAME, name, username, password, email, phoneNumber, position, UserType.SENIOR_EXECUTIVE);
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
