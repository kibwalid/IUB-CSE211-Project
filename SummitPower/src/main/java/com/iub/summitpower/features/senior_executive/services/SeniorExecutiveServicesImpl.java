package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.database.*;
import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.core.utills.ModelUtils;
import com.iub.summitpower.core.utills.RepositoryUtils;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.iub.summitpower.core.enums.UserType.*;

public class SeniorExecutiveServicesImpl extends RepositoryUtils implements ISeniorExecutiveDashboardServices, IUserServices {


    @Override
    public int numberOfCustomers() {
        return customerAgentRepositoy.getActiveCustomers();
    }

    @Override
    public int numberOfEmployees() {
        return seniorExecutiveRepository.countAll()
                + hrExecutiveRepository.countAll()
                + salesExecutiveRepository.countAll()
                + businessAnalystRespositoy.countAll()
                + projectManagerRepositoy.countAll()
                + engineerRepositoy.countAll()
                + qualityAssuranceTesterRepositoy.countAll()
                + maintenanceEngineerRepositoy.countAll()
                + customerSupportAgentRepositoy.countAll();
    }

    @Override
    public double totalCostByMonth() {
        return seniorExecutiveRepository.getTotalSalaryGiven()
                + hrExecutiveRepository.getTotalSalaryGiven()
                + salesExecutiveRepository.getTotalSalaryGiven()
                + businessAnalystRespositoy.getTotalSalaryGiven()
                + projectManagerRepositoy.getTotalSalaryGiven()
                + engineerRepositoy.getTotalSalaryGiven()
                + qualityAssuranceTesterRepositoy.getTotalSalaryGiven()
                + maintenanceEngineerRepositoy.getTotalSalaryGiven()
                + customerSupportAgentRepositoy.getTotalSalaryGiven();
    }


    @Override
    public double totalRevenueByMonth() {
        return contractRepository.earningsThisMonth();
    }

    @Override
    public List<Project> getActiveProjects() {
        return projectRepository.getAllActiveProjects();
    }

    @Override
    public boolean registerEmployee(String name, String username, String password, String email, String phoneNumber, String position, String salary, UserType employeeType) {
        double dSalary = Double.parseDouble(salary);
        switch (employeeType) {
            case SENIOR_EXECUTIVE:
                if(Setup.currentUser != null && Setup.currentUser.getUserType() != SENIOR_EXECUTIVE) {
                    ViewControlUtils.showAlert("You are not allowed to add an Executive! Please contact an executive for further assistance!");
                    return false;
                }
                return seniorExecutiveRepository.add(new SeniorExecutive(0, name, username, password, email, phoneNumber, position, dSalary, List.of()));

            case HR_EXECUTIVE:
                return hrExecutiveRepository.add(new HRExecutive(0, name, username, password, email, phoneNumber, position, List.of(), dSalary, List.of()));

            case SALES_EXECUTIVE:
                return salesExecutiveRepository.add(new SalesExecutive(0, name, username, password, email, phoneNumber, position, List.of(), dSalary, List.of(), List.of()));

            case BUSINESS_ANALYST:
                return businessAnalystRespositoy.add(new BusinessAnalyst(0, name, username, password, email, phoneNumber, position, List.of(), dSalary, List.of()));

            case PROJECT_MANAGER:
                return projectManagerRepositoy.add(new ProjectManager(0, name, username, password, email, phoneNumber, position, List.of(), dSalary, List.of(), List.of(), List.of()));

            case ENGINEER:
                return engineerRepositoy.add(new Engineer(0, name, username, password, email, phoneNumber, position, dSalary,List.of(), List.of(), List.of()));

            case QUALITY_ASSURANCE_TESTER:
                return qualityAssuranceTesterRepositoy.add(new QualityAssuranceTester(0, name, username, password, email, phoneNumber, position, dSalary,List.of(), List.of(), List.of()));

            case MAINTENANCE_ENGINEER:
                return maintenanceEngineerRepositoy.add(new MaintenanceEngineer(0, name, username, password, email, phoneNumber, position, dSalary,List.of(), List.of(), List.of()));

            case CUSTOMER_SUPPORT_AGENT:
                return customerSupportAgentRepositoy.add(new CustomerSupportAgent(0, name, username, password, email, phoneNumber, position, List.of(), dSalary, List.of()));

            default:
                ViewControlUtils.showAlert("User type is not defined. Please select user type and try again!");
                break;
        }
        ViewControlUtils.showAlert("Unable to register! Please contact Khalid.");

        return false;
    }


    @Override
    public void validateUserData(String name, String username, String password, String email, String phoneNumber, String position, String salary, UserType employeeType, String signature) {

        if(name.length() < 4) {
            ViewControlUtils.showAlert("Name must be at least 4 chars long");
        }

        if(username.length() < 4) {
            ViewControlUtils.showAlert("Username must be at least 4 chars long");
        }

        if(password.length() < 6) {
            ViewControlUtils.showAlert("Password must be at least 8 chars long");
        }

        if(phoneNumber.length() < 10) {
            ViewControlUtils.showAlert("Phone  must be at least 8 chars long");
        }

        ModelUtils.validateDouble(salary, "Salary");

        if(position.length() < 2) {
            ViewControlUtils.showAlert("Password must be at least 3 chars long");
        }

        if(employeeType == null) {
            ViewControlUtils.showAlert("Employee Type must be selected");
        }

        String compSign = Setup.currentUser.getName().split(" ")[0];
        if(Setup.currentUser != null && !Objects.equals(signature, compSign)) {
            ViewControlUtils.showAlert("Signature must be the same as your first name.");
        }

    }

    @Override
    public List<EmployeeDTO> getAllEmployeeTableData() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(SeniorExecutive employee : seniorExecutiveRepository.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(HRExecutive employee : hrExecutiveRepository.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(BusinessAnalyst employee : businessAnalystRespositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(ProjectManager employee : projectManagerRepositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(QualityAssuranceTester employee : qualityAssuranceTesterRepositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(SalesExecutive employee : salesExecutiveRepository.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(Engineer employee : engineerRepositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(MaintenanceEngineer employee : maintenanceEngineerRepositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }

        for(CustomerSupportAgent employee : customerSupportAgentRepositoy.getAllData().values()) {
            employeeDTOS.add(new EmployeeDTO(employee.getName(), employee.getPosition(),
                    employee.getUserType(), employee.getSalary(), employee.getPhoneNumber(),
                    employee.getEmail(), employee.getUsername()));
        }


        return employeeDTOS;
    }


}
