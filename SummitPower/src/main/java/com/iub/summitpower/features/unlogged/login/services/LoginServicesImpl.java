package com.iub.summitpower.features.unlogged.login.services;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.models.database.BaseUser;
import com.iub.summitpower.core.models.database.SeniorExecutive;
import com.iub.summitpower.features.hr_executive.repository.ISeniorExecutiveRepository;
import com.iub.summitpower.features.hr_executive.repository.SeniorExecutiveRepositoryImpl;

import javax.naming.AuthenticationException;
import java.util.Objects;

public class LoginServicesImpl implements ILoginServices{

    private final ISeniorExecutiveRepository seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();

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
                System.out.println("User is an HR Executive");
                break;
            case SALES_EXECUTIVE:
                System.out.println("User is a Sales Executive");
                break;
            case BUSINESS_ANALYST:
                System.out.println("User is a Business Analyst");
                break;
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
                System.out.println("Unknown user type");
                break;
        }
        return null;
    }

    private boolean passwordMatches(BaseUser user, String givenPass) {
        return Objects.equals(user.getPassword(), givenPass);
    }
}
