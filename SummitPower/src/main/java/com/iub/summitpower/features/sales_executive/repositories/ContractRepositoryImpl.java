package com.iub.summitpower.features.sales_executive.repositories;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.fucntional.Contract;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.List;
import java.util.Map;

public class ContractRepositoryImpl extends DatabaseHelper<Integer, Contract> implements BaseRepository<Integer, Contract> {
    public ContractRepositoryImpl() {
        super(Contract.ENTITY_NAME);
    }


    @Override
    public Contract getById(Integer key) {
        return get(key);
    }

    @Override
    public Map<Integer, Contract> getAllData() {
        return getAll();
    }

    @Override
    public boolean add(Contract contract) {
        return add(contract.getId(), contract);
    }

    @Override
    public int countAll() {
        return count();
    }

    public List<Contract> getActiveContracts() {
        return getAll().values().stream().toList();
    }

    public double earningsThisMonth() {
        double total = 0;

        for(Contract contract : getActiveContracts()) {
            if(contract.isActive()) {
                total += contract.getTotalContractAmount() / contract.durationInMonthNumbers();
            }
        }

        return total;
    }


}
