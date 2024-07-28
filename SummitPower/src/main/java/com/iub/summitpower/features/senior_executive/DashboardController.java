package com.iub.summitpower.features.senior_executive;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.features.senior_executive.services.ISeniorExecutiveDashboardServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class DashboardController extends NavigationHelper {


    @FXML
    public Label employeeCountLabel;

    @FXML
    public Label activeCustomerLabel;

    @FXML
    public Label monthlyCostLabel;

    @FXML
    public Label monthlyEarningLabel;

    @FXML
    public Label userNameLabel;

    @FXML
    public Label userPositionLabel;

    @FXML
    public Label addEmployeLabel;

    @FXML
    public Label employeeListLabel;
    
    @FXML
    public Label customerListLabel;


    private final ISeniorExecutiveDashboardServices seniorExecutiveServices = new SeniorExecutiveServicesImpl();
    

    @FXML
    public void initialize() {
        employeeCountLabel.setText(String.valueOf(seniorExecutiveServices.numberOfEmployees()));
        activeCustomerLabel.setText(String.valueOf(seniorExecutiveServices.numberOfCustomers()));
        monthlyCostLabel.setText(seniorExecutiveServices.totalCostByMonth() + "Tk");
        monthlyEarningLabel.setText(seniorExecutiveServices.totalRevenueByMonth() + "Tk");
    }

}
