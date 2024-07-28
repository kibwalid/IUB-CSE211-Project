package com.iub.summitpower.features.senior_executive;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerListController {

    @FXML
    public TableView<?> activeProjectsTableView;

    @FXML
    public TableColumn<?, ?> budgetCol;

    @FXML
    public TableColumn<?, ?> deadlineCol;

    @FXML
    public Button detailsButton;

    @FXML
    public Button detailsButton1;

    @FXML
    public Label label;

    @FXML
    public TableColumn<?, ?> managerNameCol;

    @FXML
    public TableColumn<?, ?> projectNameCol;

    @FXML
    public Label userPositionLabel1;

    @FXML
    public Label userPositionLabel11;

    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void initialize() {


    }

}
