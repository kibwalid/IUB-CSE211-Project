package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.database.*;
import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.models.EmployeeDetailsDTO;

import java.util.List;

public interface IUserServices {

    boolean registerEmployee(String name, String username, String password, String email, String phoneNumber, String position, String salary, UserType employeeType);

    void validateUserData(String name, String username, String password, String email, String phoneNumber, String position, String salary, UserType employeeType, String signature);

    List<EmployeeDTO> getAllEmployeeTableData();

    boolean deleteUser(String userName, UserType userType);

    EmployeeDetailsDTO getSingleEmployee(String username, UserType type);

}
