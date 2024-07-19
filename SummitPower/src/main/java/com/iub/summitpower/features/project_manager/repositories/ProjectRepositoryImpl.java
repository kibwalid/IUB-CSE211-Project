package com.iub.summitpower.features.project_manager.repositories;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.core.entities.fucntional.Project;
import com.iub.summitpower.core.enums.Status;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.List;
import java.util.Map;

public class ProjectRepositoryImpl extends DatabaseHelper<Integer, Project> implements BaseRepository<Integer, Project> {

    public ProjectRepositoryImpl() {
        super(Project.ENTITY_NAME);
    }

    @Override
    public Project getById(Integer key) {
        return get(key);
    }

    @Override
    public Map<Integer, Project> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(Project user) {
        return add(user.getId(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public List<Project> getAllActiveProjects() {
        return getAllData().values()
                .stream()
                .filter(project -> project.getStatus() != Status.ONGOING)
                .toList();
    }


}
