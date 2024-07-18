package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.features.senior_executive.repository.SeniorExecutiveRepositoryImpl;

import java.util.List;

public class SeniorExecutiveServices implements ISeniorExecutiveServices {

    private final SeniorExecutiveRepositoryImpl seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();

    @Override
    public int numberOfCustomers() {
        return 0;
    }

    @Override
    public int numberOfEmployees() {
        int total = seniorExecutiveRepository.countExecutives();
        return total;
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
