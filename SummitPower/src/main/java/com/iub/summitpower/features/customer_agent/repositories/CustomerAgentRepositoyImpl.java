package com.iub.summitpower.features.customer_agent.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.CustomerAgent;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class CustomerAgentRepositoyImpl extends DatabaseHelper<String, CustomerAgent> implements BaseRepository<String, CustomerAgent> {
    public CustomerAgentRepositoyImpl() {
        super(CustomerAgent.ENTITY_NAME);
    }

    @Override
    public CustomerAgent getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, CustomerAgent> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(CustomerAgent user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public int getActiveCustomers() {
        return getAll().values()
                .stream().
                filter(customer -> !customer.getContracts().isEmpty())
                .toList()
                .size();
    }
}
