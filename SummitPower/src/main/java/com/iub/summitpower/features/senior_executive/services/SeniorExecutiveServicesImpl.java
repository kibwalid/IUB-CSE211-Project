package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.database.*;
import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.core.utills.ModelUtils;
import com.iub.summitpower.core.utills.RepositoryUtils;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.models.EmployeeDetailsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.iub.summitpower.core.enums.UserType.*;

public class SeniorExecutiveServicesImpl extends RepositoryUtils implements ISeniorExecutiveDashboardServices, IUserServices {

    public static EmployeeDTO selectedEmployeeBySE = null;

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

    @Override
    public boolean deleteUser(String userName, UserType userType) {


        if(Objects.equals(Setup.currentUser.getUsername(), userName)) {
            ViewControlUtils.showAlert("You can not remove yourself from the company.");
            return false;
        }

        switch (userType) {
            case SENIOR_EXECUTIVE:
                if(Setup.currentUser.getUserType() == HR_EXECUTIVE) {
                    ViewControlUtils.showAlert("You can not remove an Executive from the company.");
                    return false;
                }
                return seniorExecutiveRepository.delete(userName);

            case HR_EXECUTIVE:
                return hrExecutiveRepository.delete(userName);

            case SALES_EXECUTIVE:
                return salesExecutiveRepository.delete(userName);

            case BUSINESS_ANALYST:
                return businessAnalystRespositoy.delete(userName);

            case PROJECT_MANAGER:
                return projectManagerRepositoy.delete(userName);

            case ENGINEER:
                return engineerRepositoy.delete(userName);

            case QUALITY_ASSURANCE_TESTER:
                return qualityAssuranceTesterRepositoy.delete(userName);

            case MAINTENANCE_ENGINEER:
                return maintenanceEngineerRepositoy.delete(userName);

            case CUSTOMER_SUPPORT_AGENT:
                return customerSupportAgentRepositoy.delete(userName);

            default:
                ViewControlUtils.showAlert("User type is not defined. Please select user type and try again!");
                break;
        }
        ViewControlUtils.showAlert("Unable to remove user! Please contact Khalid.");

        return false;
    }

    @Override
    public EmployeeDetailsDTO getSingleEmployee(String username, UserType type) {

        if(Objects.equals(Setup.currentUser.getUsername(), username)) {
            return new EmployeeDetailsDTO(Setup.currentUser.getPersonalInformation(),
                    Setup.currentUser.getAuditInformation(),
                    Setup.currentUser.getWorkHistoryAsText(),
                    Setup.currentUser.getAddedBy().getName().split(" ")[0]);
        }

        switch (type) {
            case SENIOR_EXECUTIVE:
                SeniorExecutive seniorExecutive = seniorExecutiveRepository.getById(username);
                return new EmployeeDetailsDTO(seniorExecutive.getPersonalInformation(),
                        seniorExecutive.getAuditInformation(),
                        seniorExecutive.getWorkHistoryAsText(),
                        seniorExecutive.getAddedBy().getName().split(" ")[0]);

            case HR_EXECUTIVE:
                HRExecutive hrExecutive = hrExecutiveRepository.getById(username);
                return new EmployeeDetailsDTO(hrExecutive.getPersonalInformation(),
                        hrExecutive.getAuditInformation(),
                        hrExecutive.getWorkHistoryAsText(),
                        hrExecutive.getAddedBy().getName().split(" ")[0]);

            case SALES_EXECUTIVE:
                SalesExecutive salesExecutive = salesExecutiveRepository.getById(username);
                return new EmployeeDetailsDTO(salesExecutive.getPersonalInformation(),
                        salesExecutive.getAuditInformation(),
                        salesExecutive.getWorkHistoryAsText(),
                        salesExecutive.getAddedBy().getName().split(" ")[0]);

            case BUSINESS_ANALYST:
                BusinessAnalyst businessAnalyst = businessAnalystRespositoy.getById(username);
                return new EmployeeDetailsDTO(businessAnalyst.getPersonalInformation(),
                        businessAnalyst.getAuditInformation(),
                        businessAnalyst.getWorkHistoryAsText(),
                        businessAnalyst.getAddedBy().getName().split(" ")[0]);

            case PROJECT_MANAGER:
                ProjectManager projectManager = projectManagerRepositoy.getById(username);
                return new EmployeeDetailsDTO(projectManager.getPersonalInformation(),
                        projectManager.getAuditInformation(),
                        projectManager.getWorkHistoryAsText(),
                        projectManager.getAddedBy().getName().split(" ")[0]);

            case ENGINEER:
                Engineer engineer = engineerRepositoy.getById(username);
                return new EmployeeDetailsDTO(engineer.getPersonalInformation(),
                        engineer.getAuditInformation(),
                        engineer.getWorkHistoryAsText(),
                        engineer.getAddedBy().getName().split(" ")[0]);

            case QUALITY_ASSURANCE_TESTER:
                QualityAssuranceTester qualityAssuranceTester = qualityAssuranceTesterRepositoy.getById(username);
                return new EmployeeDetailsDTO(qualityAssuranceTester.getPersonalInformation(),
                        qualityAssuranceTester.getAuditInformation(),
                        qualityAssuranceTester.getWorkHistoryAsText(),
                        qualityAssuranceTester.getName().split(" ")[0]);

            case MAINTENANCE_ENGINEER:
                MaintenanceEngineer maintenanceEngineer = maintenanceEngineerRepositoy.getById(username);
                return new EmployeeDetailsDTO(maintenanceEngineer.getPersonalInformation(),
                        maintenanceEngineer.getAuditInformation(),
                        maintenanceEngineer.getWorkHistoryAsText(),
                        maintenanceEngineer.getAddedBy().getName().split(" ")[0]);

            case CUSTOMER_SUPPORT_AGENT:
                CustomerSupportAgent customerSupportAgent = customerSupportAgentRepositoy.getById(username);
                return new EmployeeDetailsDTO(customerSupportAgent.getPersonalInformation(),
                        customerSupportAgent.getAuditInformation(),
                        customerSupportAgent.getWorkHistoryAsText(),
                        customerSupportAgent.getAddedBy().getName().split(" ")[0]);

            default:
                ViewControlUtils.showAlert("User type is not defined. Please select user type and try again!");
                break;
        }
        ViewControlUtils.showAlert("Unable to fetch user! Please contact Khalid.");

        return null;
    }


}
