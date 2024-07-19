package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.database.BaseUser;
import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.core.utills.RepositoryUtils;
import com.iub.summitpower.features.business_analyst.repositories.BusinessAnalystRespositoyImpl;
import com.iub.summitpower.features.customer_agent.repositories.CustomerAgentRepositoyImpl;
import com.iub.summitpower.features.customer_support_agent.repositories.CustomerSupportAgentRepositoyImpl;
import com.iub.summitpower.features.engineer.repositories.EngineerRepositoyImpl;
import com.iub.summitpower.features.hr_executive.repositories.HRExecutiveRepositoryImpl;
import com.iub.summitpower.features.maintenance_engineer.repositories.MaintenanceEngineerRepositoyImpl;
import com.iub.summitpower.features.project_manager.repositories.ProjectManagerRepositoyImpl;
import com.iub.summitpower.features.project_manager.repositories.ProjectRepositoryImpl;
import com.iub.summitpower.features.quality_assurance_tester.repositories.QualityAssuranceTesterRepositoyImpl;
import com.iub.summitpower.features.sales_executive.repositories.ContractRepositoryImpl;
import com.iub.summitpower.features.sales_executive.repositories.SalesExecutiveRepositoryImpl;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

import java.util.List;

public class SeniorExecutiveServicesImpl extends RepositoryUtils implements ISeniorExecutiveServices {


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
}
