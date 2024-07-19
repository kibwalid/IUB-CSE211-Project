package com.iub.summitpower.features.quality_assurance_tester.repositories;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.core.entities.database.Engineer;
import com.iub.summitpower.core.entities.database.ProjectManager;
import com.iub.summitpower.core.entities.database.QualityAssuranceTester;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class QualityAssuranceTesterRepositoyImpl extends DatabaseHelper<String, QualityAssuranceTester> implements BaseRepository<String, QualityAssuranceTester> {
    public QualityAssuranceTesterRepositoyImpl() {
        super(QualityAssuranceTester.ENTITY_NAME);
    }

    @Override
    public QualityAssuranceTester getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, QualityAssuranceTester> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(QualityAssuranceTester user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (QualityAssuranceTester tester : getAllData().values()) {
            total += tester.getSalary();
        }
        return total;
    }
}
