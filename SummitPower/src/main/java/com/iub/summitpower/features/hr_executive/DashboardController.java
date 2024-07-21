package com.iub.summitpower.features.hr_executive;


import com.iub.summitpower.core.enums.UserType;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
