package com.iub.summitpower.features.hr_executive.models;

import com.iub.summitpower.core.enums.UserType;

public class UserForMessageDTO {
    private String username;
    private String name;
    private String position;
    private UserType userType;

    public UserForMessageDTO(String username, String name, String position, UserType userType) {
        this.username = username;
        this.name = name;
        this.position = position;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return this.name + " ( " + this.position + ")";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
