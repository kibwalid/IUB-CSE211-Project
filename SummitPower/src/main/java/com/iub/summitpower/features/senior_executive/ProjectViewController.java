package com.iub.summitpower.features.senior_executive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProjectViewController {


    @FXML
    public Label budgetAllocatedLabel;

    @FXML
    public TableColumn<?, ?> budgetCol;

    @FXML
    public Label budgetSpentLabel;

    @FXML
    public TableColumn<?, ?> deadlineCol;

    @FXML
    public Button detailsButton;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public Label ongoingProjectLabel;

    @FXML
    public TableColumn<?, ?> projectManagerCol;

    @FXML
    public TableView<?> projectTableView;

    @FXML
    public TableColumn<?, ?> startDateCol;

    @FXML
    public TableColumn<?, ?> statusCol;

    @FXML
    public Label totalProjectLabel;

    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void initialize() {


    }

}
