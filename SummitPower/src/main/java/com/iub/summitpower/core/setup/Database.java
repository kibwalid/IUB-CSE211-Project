package com.iub.summitpower.core.setup;

import com.iub.summitpower.core.BaseRepository;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

public class Database {

    public static void initializeDatabase() {
        BaseRepository seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    }
}
