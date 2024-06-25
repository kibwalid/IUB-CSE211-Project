package com.iub.summitpower.core.setup;

import com.iub.summitpower.features.hr_executive.repository.ISeniorExecutiveRepository;
import com.iub.summitpower.features.hr_executive.repository.SeniorExecutiveRepositoryImpl;

public class Database {

    public static void initializeDatabase() {
        ISeniorExecutiveRepository seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    }
}
