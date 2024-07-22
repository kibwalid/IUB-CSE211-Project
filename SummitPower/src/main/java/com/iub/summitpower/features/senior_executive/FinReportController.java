package com.iub.summitpower.features.senior_executive;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FinReportController {

    @FXML
    public Label activeContractLabel;

    @FXML
    public TableColumn<?, ?> amountCol;

    @FXML
    public TableColumn<?, ?> companyName;

    @FXML
    public TableView<?> contractTableView;

    @FXML
    public Button detailsButton;

    @FXML
    public BarChart<?, ?> earningsByMonthBarChart;

    @FXML
    public TableColumn<?, ?> kwPerMonthCol;

    @FXML
    public ComboBox<?> monthComboBox;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public TableColumn<?, ?> statusCol;

    @FXML
    public Label totalRevenueLabel;

    @FXML
    public ComboBox<?> yearComboBox;

    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void initialize() {


    }

}
