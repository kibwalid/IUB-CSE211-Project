package com.iub.summitpower.features.sales_executive.repositories;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.core.entities.database.HRExecutive;
import com.iub.summitpower.core.entities.database.SalesExecutive;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class SalesExecutiveRepositoryImpl extends DatabaseHelper<String, SalesExecutive> implements BaseRepository<String, SalesExecutive> {
    public SalesExecutiveRepositoryImpl() {
        super(SalesExecutive.ENTITY_NAME);
    }

    @Override
    public SalesExecutive getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, SalesExecutive> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(SalesExecutive user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (SalesExecutive executive : getAllData().values()) {
            total += executive.getSalary();
        }
        return total;
    }
}
