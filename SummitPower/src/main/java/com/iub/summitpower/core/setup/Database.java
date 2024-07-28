package com.iub.summitpower.core.setup;

import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.entities.database.SeniorExecutive;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

public class Database {

    public static void initializeDatabase() {
        BaseRepository<String, SeniorExecutive> seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    }
}
