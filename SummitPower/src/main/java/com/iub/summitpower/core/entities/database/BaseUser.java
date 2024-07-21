package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Setup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseUser extends BaseEntity {

    private String name;
    private String username;
    private String password;

    private String email;
    private String phoneNumber;
    private String position;
    private UserType userType;

    private BaseUser addedBy;


    public BaseUser() {
        super();
    }

    public BaseUser(boolean system) {
        // for the system when unlogged
        this.username = "SYSTEM-UNLOGGED";
    }

    public BaseUser(int id, String modelName, String name, String username, String password, String email, String phoneNumber, String position, UserType userType) {
        super(id, modelName);
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.userType = userType;
        this.addedBy = Setup.currentUser;
    }

    public String getPersonalInformation() {
        return this.name + " (" + this.position + ") \n"
                + this.userType + "\n\n"
                + "Phone : " + this.phoneNumber + "\n"
                + "Email : " + this.email + "\n";
    }

    public String getAuditInformation() {
        return "This user has been added by " + this.name + " at " + this.getAddedAt().format(DateTimeFormatter.ISO_DATE);
    }

    public String getWorkHistoryAsText() {
        return "Work history of this employee is classified information!";
    }

    public BaseUser getAddedBy() {
        return addedBy == null ? this : addedBy;
    }

    public void setAddedBy(BaseUser addedBy) {
        this.addedBy = addedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
