package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.features.business_analyst.repositories.BusinessAnalystRespositoyImpl;
import com.iub.summitpower.features.hr_executive.repositories.HRExecutiveRepositoryImpl;
import com.iub.summitpower.features.sales_executive.repositories.SalesExecutiveRepositoryImpl;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

import java.util.List;

public class SeniorExecutiveServicesImpl implements ISeniorExecutiveServices {

    private final SeniorExecutiveRepositoryImpl seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    private final HRExecutiveRepositoryImpl hrExecutiveRepository = new HRExecutiveRepositoryImpl();
    private final SalesExecutiveRepositoryImpl salesExecutiveRepository = new SalesExecutiveRepositoryImpl();
    private final BusinessAnalystRespositoyImpl businessAnalystRespositoy = new BusinessAnalystRespositoyImpl();


    @Override
    public int numberOfCustomers() {
        return 0;
    }

    @Override
    public int numberOfEmployees() {
        return seniorExecutiveRepository.countAll()
                + hrExecutiveRepository.countAll()
                + salesExecutiveRepository.countAll()
                + businessAnalystRespositoy.countAll();
    }

    @Override
    public double totalCost() {
        return 0;
    }

    @Override
    public double totalRevenue() {
        return 0;
    }

    @Override
    public List<Project> getActiveProjects() {
        return List.of();
    }
}
