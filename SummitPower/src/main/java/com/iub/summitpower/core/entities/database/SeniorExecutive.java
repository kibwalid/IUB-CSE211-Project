package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.enums.UserType;

public class SeniorExecutive extends BaseUser{

    public final static String ENTITY_NAME = "SeniorExecutive";

    public SeniorExecutive() {
        super();
    }

    public SeniorExecutive(int id, String name, String username, String password, String email, String phoneNumber, String position, double salary) {
        super(id, SeniorExecutive.ENTITY_NAME, name, username, password, email, phoneNumber, position, UserType.SENIOR_EXECUTIVE);
        this.salary = salary;
    }

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SeniorExecutive{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", salary=" + salary +
                '}';
    }
}
