package com.iub.summitpower.core.utills;

import com.iub.summitpower.features.business_analyst.repositories.BusinessAnalystRespositoyImpl;
import com.iub.summitpower.features.customer_agent.repositories.CustomerAgentRepositoyImpl;
import com.iub.summitpower.features.customer_support_agent.repositories.CustomerSupportAgentRepositoyImpl;
import com.iub.summitpower.features.engineer.repositories.EngineerRepositoyImpl;
import com.iub.summitpower.features.hr_executive.repositories.HRExecutiveRepositoryImpl;
import com.iub.summitpower.features.maintenance_engineer.repositories.MaintenanceEngineerRepositoyImpl;
import com.iub.summitpower.features.project_manager.repositories.ProjectManagerRepositoyImpl;
import com.iub.summitpower.features.project_manager.repositories.ProjectRepositoryImpl;
import com.iub.summitpower.features.quality_assurance_tester.repositories.QualityAssuranceTesterRepositoyImpl;
import com.iub.summitpower.features.sales_executive.repositories.ContractRepositoryImpl;
import com.iub.summitpower.features.sales_executive.repositories.SalesExecutiveRepositoryImpl;
import com.iub.summitpower.features.senior_executive.repositories.SeniorExecutiveRepositoryImpl;

public abstract class RepositoryUtils {
    protected final SeniorExecutiveRepositoryImpl seniorExecutiveRepository = new SeniorExecutiveRepositoryImpl();
    protected final HRExecutiveRepositoryImpl hrExecutiveRepository = new HRExecutiveRepositoryImpl();
    protected final SalesExecutiveRepositoryImpl salesExecutiveRepository = new SalesExecutiveRepositoryImpl();
    protected final BusinessAnalystRespositoyImpl businessAnalystRespositoy = new BusinessAnalystRespositoyImpl();
    protected final ProjectManagerRepositoyImpl projectManagerRepositoy = new ProjectManagerRepositoyImpl();
    protected final EngineerRepositoyImpl engineerRepositoy = new EngineerRepositoyImpl();
    protected final QualityAssuranceTesterRepositoyImpl qualityAssuranceTesterRepositoy = new QualityAssuranceTesterRepositoyImpl();
    protected final MaintenanceEngineerRepositoyImpl maintenanceEngineerRepositoy = new MaintenanceEngineerRepositoyImpl();
    protected final CustomerAgentRepositoyImpl customerAgentRepositoy = new CustomerAgentRepositoyImpl();
    protected final CustomerSupportAgentRepositoyImpl customerSupportAgentRepositoy = new CustomerSupportAgentRepositoyImpl();

    protected final ContractRepositoryImpl contractRepository = new ContractRepositoryImpl();
    protected final ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
}
