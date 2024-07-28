package com.iub.summitpower.features.hr_executive;


import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;

public class DashboardController {


    @FXML
    public StackedBarChart<String, Double> budgetStracktedBar;

    @FXML
    public Label engineerCountLabel;

    @FXML
    public Label maintainCountLabel;

    @FXML
    public Label managementCountLabel;

    @FXML
    public Label unpaidEmployeeLabel;

    @FXML
    public void initialize() {


    }

}
