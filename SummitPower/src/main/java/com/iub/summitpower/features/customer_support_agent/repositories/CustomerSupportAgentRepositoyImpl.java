package com.iub.summitpower.features.customer_support_agent.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.CustomerSupportAgent;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.Map;

public class CustomerSupportAgentRepositoyImpl extends DatabaseHelper<String, CustomerSupportAgent> implements BaseRepository<String, CustomerSupportAgent> {
    public CustomerSupportAgentRepositoyImpl() {
        super(CustomerSupportAgent.ENTITY_NAME);
    }

    @Override
    public CustomerSupportAgent getById(String username) {
        return get(username);
    }

    @Override
    public Map<String, CustomerSupportAgent> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(CustomerSupportAgent user) {
        return add(user.getUsername(), user);
    }

    @Override
    public int countAll() {
        return count();
    }

    public double getTotalSalaryGiven() {
        double total = 0;
        for (CustomerSupportAgent supportAgent : getAllData().values()) {
            total += supportAgent.getSalary();
        }
        return total;
    }

    public boolean delete(String username) {
        return deleteRecord(username);
    }
}
