package com.iub.summitpower.features.senior_executive.repositories;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.core.entities.database.SeniorExecutive;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class SeniorExecutiveRepositoryImpl extends DatabaseHelper<String, SeniorExecutive> implements BaseRepository<String, SeniorExecutive> {


    public SeniorExecutiveRepositoryImpl() {
        super(SeniorExecutive.ENTITY_NAME);
    }

    @Override
    public SeniorExecutive getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, SeniorExecutive> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(SeniorExecutive user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (SeniorExecutive executive : getAllData().values()) {
            total += executive.getSalary();
        }
        return total;
    }


}
