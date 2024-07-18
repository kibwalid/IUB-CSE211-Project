package com.iub.summitpower.core.setup;

import com.iub.summitpower.features.senior_executive.repository.ISeniorExecutiveRepository;
import com.iub.summitpower.features.senior_executive.repository.SeniorExecutiveRepositoryImpl;

public class Database {

    public static void initializeDatabase() {
        ISeniorExecutiveRepository seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    }
}
