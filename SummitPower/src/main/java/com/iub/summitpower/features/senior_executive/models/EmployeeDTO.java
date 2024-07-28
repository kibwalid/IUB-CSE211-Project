package com.iub.summitpower.features.senior_executive.models;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.scene.control.Button;

public class EmployeeDTO extends NavigationHelper {
    private String name;
    private String position;
    private UserType userType;
    private double salary;
    private String phoneNumber;
    private String email;
    private String userName;

    public EmployeeDTO(String name, String position, UserType userType, double salary, String phoneNumber, String email, String username) {
        this.name = name;
        this.position = position;
        this.userType = userType;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
