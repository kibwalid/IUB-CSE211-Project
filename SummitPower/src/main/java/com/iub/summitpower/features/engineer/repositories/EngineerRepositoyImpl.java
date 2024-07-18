package com.iub.summitpower.features.engineer.repositories;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.core.entities.database.Engineer;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class EngineerRepositoyImpl extends DatabaseHelper<String, Engineer> implements BaseRepository<String, Engineer> {
    public EngineerRepositoyImpl() {
        super(Engineer.ENTITY_NAME);
    }

    @Override
    public Engineer getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, Engineer> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(Engineer user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }
}
