package com.iub.summitpower.features.hr_executive.repository;

import com.iub.summitpower.core.models.database.SeniorExecutive;

import java.util.Map;

public interface ISeniorExecutiveRepository {

    SeniorExecutive getById(String username);
    Map<String, SeniorExecutive> getAllExecutive();
    boolean addExecutive(SeniorExecutive user);
    int countExecutives();
}
