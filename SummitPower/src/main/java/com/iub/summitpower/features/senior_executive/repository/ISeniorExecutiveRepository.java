package com.iub.summitpower.features.senior_executive.repository;

import com.iub.summitpower.core.entities.database.SeniorExecutive;

import java.util.Map;

public interface ISeniorExecutiveRepository {

    SeniorExecutive getById(String username);
    Map<String, SeniorExecutive> getAllExecutive();
    boolean addExecutive(SeniorExecutive user);
    int countExecutives();
}
