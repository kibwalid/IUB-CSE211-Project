package com.iub.summitpower.features.project_manager.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.ProjectManager;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class ProjectManagerRepositoyImpl extends DatabaseHelper<String, ProjectManager> implements BaseRepository<String, ProjectManager> {
    public ProjectManagerRepositoyImpl() {
        super(ProjectManager.ENTITY_NAME);
    }

    @Override
    public ProjectManager getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, ProjectManager> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(ProjectManager user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (ProjectManager manager : getAllData().values()) {
            total += manager.getSalary();
        }
        return total;
    }
}
