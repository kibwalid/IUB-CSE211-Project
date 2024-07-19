package com.iub.summitpower.features.maintenance_engineer.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.MaintenanceEngineer;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class MaintenanceEngineerRepositoyImpl extends DatabaseHelper<String, MaintenanceEngineer> implements BaseRepository<String, MaintenanceEngineer> {
    public MaintenanceEngineerRepositoyImpl() {
        super(MaintenanceEngineer.ENTITY_NAME);
    }

    @Override
    public MaintenanceEngineer getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, MaintenanceEngineer> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(MaintenanceEngineer user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (MaintenanceEngineer maintenanceEngineer : getAllData().values()) {
            total += maintenanceEngineer.getSalary();
        }
        return total;
    }
}
