package com.iub.summitpower.core.setup;

import com.iub.summitpower.core.entities.database.SeniorExecutive;
import com.iub.summitpower.features.senior_executive.repository.ISeniorExecutiveRepository;
import com.iub.summitpower.features.senior_executive.repository.SeniorExecutiveRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class Setup {
    public void injectDependencies() throws IOException {
        Database.initializeDatabase();
        Screens.loadNavigationItems();
    }

    public void createDefaultUsers() {
        addSeniorExecutive();
    }

    private void addSeniorExecutive() {
        ISeniorExecutiveRepository seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
        SeniorExecutive executive = new SeniorExecutive(
                seniorExecutiveRepository.countExecutives()+1,
                "Khalid Ibnul",
                "admin",
                "admin",
                "kibwalid@gmail.com",
                "+880-11914-21477",
                "CEO",
                6000000,
                List.of()
        );
        if(seniorExecutiveRepository.addExecutive(executive)) {
            System.out.println("Added initial Senior Executive");
        } else {
            System.out.println("Unable to add initial Senior Executive");
        }
        System.out.println(seniorExecutiveRepository.getAllExecutive());
    }

}
