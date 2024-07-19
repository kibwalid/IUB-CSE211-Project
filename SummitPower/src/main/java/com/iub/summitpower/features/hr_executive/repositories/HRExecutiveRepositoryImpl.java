package com.iub.summitpower.features.hr_executive.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.HRExecutive;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class HRExecutiveRepositoryImpl extends DatabaseHelper<String, HRExecutive> implements BaseRepository<String, HRExecutive> {

    public HRExecutiveRepositoryImpl() {
        super(HRExecutive.ENTITY_NAME);
    }

    @Override
    public HRExecutive getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, HRExecutive> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(HRExecutive user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (HRExecutive executive : getAllData().values()) {
            total += executive.getSalary();
        }
        return total;
    }
}
