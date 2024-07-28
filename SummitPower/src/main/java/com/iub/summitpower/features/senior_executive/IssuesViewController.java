package com.iub.summitpower.features.senior_executive;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IssuesViewController {


    @FXML
    public Label activeIssuesLabel;

    @FXML
    public TableColumn<?, ?> costToFixCol;

    @FXML
    public TableColumn<?, ?> deadlineCol;

    @FXML
    public Button detailsButton;

    @FXML
    public Label fixedIssuesLabel;

    @FXML
    public BarChart<?, ?> issuesByMonthBarChart;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public TableView<?> projectTableView;

    @FXML
    public TableColumn<?, ?> qaManagerCol;

    @FXML
    public TableColumn<?, ?> statusCol;

    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void initialize() {


    }

}
