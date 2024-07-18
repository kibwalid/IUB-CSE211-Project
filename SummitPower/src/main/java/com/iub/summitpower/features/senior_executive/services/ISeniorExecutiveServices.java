package com.iub.summitpower.features.senior_executive.services;

import com.iub.summitpower.core.entities.fucntional.Project;

import java.util.List;

public interface ISeniorExecutiveServices {
    int numberOfCustomers();
    int numberOfEmployees();
    double totalCost();
    double totalRevenue();

    List<Project> getActiveProjects();

}
