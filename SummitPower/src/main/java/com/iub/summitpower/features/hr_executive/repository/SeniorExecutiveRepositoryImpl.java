package com.iub.summitpower.features.hr_executive.repository;

import com.iub.summitpower.core.models.database.SeniorExecutive;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class SeniorExecutiveRepositoryImpl extends DatabaseHelper<String, SeniorExecutive> implements ISeniorExecutiveRepository {


    public SeniorExecutiveRepositoryImpl() {
        super(SeniorExecutive.ENTITY_NAME, SeniorExecutive.class);
    }

    @Override
    public SeniorExecutive getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, SeniorExecutive> getAllExecutive() {
        return getAll();
    }

    @Override
    public boolean addExecutive(SeniorExecutive user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countExecutives() {
        return count();
    }


}
