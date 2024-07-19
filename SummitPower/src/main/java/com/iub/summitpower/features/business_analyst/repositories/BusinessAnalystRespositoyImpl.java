package com.iub.summitpower.features.business_analyst.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.BusinessAnalyst;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class BusinessAnalystRespositoyImpl extends DatabaseHelper<String, BusinessAnalyst> implements BaseRepository<String, BusinessAnalyst> {
    public BusinessAnalystRespositoyImpl() {
        super(BusinessAnalyst.ENTITY_NAME);
    }

    @Override
    public BusinessAnalyst getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, BusinessAnalyst> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(BusinessAnalyst user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (BusinessAnalyst analyst : getAllData().values()) {
            total += analyst.getSalary();
        }
        return total;
    }
}
