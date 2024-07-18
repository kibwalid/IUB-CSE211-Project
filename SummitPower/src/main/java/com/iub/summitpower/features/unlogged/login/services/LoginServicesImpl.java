package com.iub.summitpower.features.unlogged.login.services;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.entities.database.BaseUser;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.business_analyst.repositories.BusinessAnalystRespositoyImpl;
import com.iub.summitpower.features.hr_executive.repositories.HRExecutiveRepositoryImpl;
import com.iub.summitpower.features.sales_executive.repositories.SalesExecutiveRepositoryImpl;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

import java.util.Objects;

public class LoginServicesImpl implements ILoginServices{

    private final SeniorExecutiveRepositoryImpl seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    private final HRExecutiveRepositoryImpl hrExecutiveRepository = new HRExecutiveRepositoryImpl();
    private final SalesExecutiveRepositoryImpl salesExecutiveRepository = new SalesExecutiveRepositoryImpl();
    private final BusinessAnalystRespositoyImpl businessAnalystRespositoy = new BusinessAnalystRespositoyImpl();

    @Override
    public boolean login(String username, String password, UserType userType) throws Exception {
        BaseUser user = getIfUserExists(username, userType);
        if(user != null && passwordMatches(user, password)) {
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
                System.out.println("User is a Project Manager");
                break;
            case ENGINEER:
                System.out.println("User is an Engineer");
                break;
            case QUALITY_ASSURANCE_TESTER:
                System.out.println("User is a Quality Assurance Tester");
                break;
            case MAINTENANCE_ENGINEER:
                System.out.println("User is a Maintenance Engineer");
                break;
            case CUSTOMER_AGENT:
                System.out.println("User is a Customer Agent");
                break;
            case CUSTOMER_SUPPORT_AGENT:
                System.out.println("User is a Customer Support Agent");
                break;
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
