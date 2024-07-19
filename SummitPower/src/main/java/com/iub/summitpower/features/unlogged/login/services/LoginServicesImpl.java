package com.iub.summitpower.features.unlogged.login.services;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.entities.database.BaseUser;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.core.utills.RepositoryUtils;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.business_analyst.repositories.BusinessAnalystRespositoyImpl;
import com.iub.summitpower.features.customer_agent.repositories.CustomerAgentRepositoyImpl;
import com.iub.summitpower.features.customer_support_agent.repositories.CustomerSupportAgentRepositoyImpl;
import com.iub.summitpower.features.engineer.repositories.EngineerRepositoyImpl;
import com.iub.summitpower.features.hr_executive.repositories.HRExecutiveRepositoryImpl;
import com.iub.summitpower.features.maintenance_engineer.repositories.MaintenanceEngineerRepositoyImpl;
import com.iub.summitpower.features.project_manager.repositories.ProjectManagerRepositoyImpl;
import com.iub.summitpower.features.quality_assurance_tester.repositories.QualityAssuranceTesterRepositoyImpl;
import com.iub.summitpower.features.sales_executive.repositories.SalesExecutiveRepositoryImpl;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

import java.util.Objects;

public class LoginServicesImpl extends RepositoryUtils implements ILoginServices{


    @Override
    public boolean login(String username, String password, UserType userType) throws Exception {
        BaseUser user = getIfUserExists(username, userType);
        if(user != null && passwordMatches(user, password)) {
            Setup.currentUser = user;
            return true;
        }
        throw new Exception("Username and password does not match! Please try again or contact our customer support agents.");
    }

    private BaseUser getIfUserExists(String username, UserType userType) {
        switch (userType) {
            case SENIOR_EXECUTIVE:
                return seniorExecutiveRepository.getById(username);
            case HR_EXECUTIVE:
                return hrExecutiveRepository.getById(username);
            case SALES_EXECUTIVE:
                return salesExecutiveRepository.getById(username);
            case BUSINESS_ANALYST:
                return businessAnalystRespositoy.getById(username);
            case PROJECT_MANAGER:
                return projectManagerRepositoy.getById(username);
            case ENGINEER:
                return engineerRepositoy.getById(username);
            case QUALITY_ASSURANCE_TESTER:
                return qualityAssuranceTesterRepositoy.getById(username);
            case MAINTENANCE_ENGINEER:
                return maintenanceEngineerRepositoy.getById(username);
            case CUSTOMER_AGENT:
                return customerAgentRepositoy.getById(username);
            case CUSTOMER_SUPPORT_AGENT:
                return customerSupportAgentRepositoy.getById(username);
            default:
                ViewControlUtils.showAlert("User type is not defined. Please select user type and try again!");
                break;
        }

        return null;
    }

    private boolean passwordMatches(BaseUser user, String givenPass) {
        return Objects.equals(user.getPassword(), givenPass);
    }
}
