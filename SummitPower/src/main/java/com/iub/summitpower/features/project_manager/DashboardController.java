package com.iub.summitpower.features.project_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    public Label allocatedBudgetLabel;

    @FXML
    public StackedBarChart<?, ?> budgetStracktedBar;

    @FXML
    public Label finishedTaskLabel;

    @FXML
    public Label ongoingProjectsLabel;

    @FXML
    public Label remainingBudgetLabel;

    @FXML
    public void initialize() {


    }

}
