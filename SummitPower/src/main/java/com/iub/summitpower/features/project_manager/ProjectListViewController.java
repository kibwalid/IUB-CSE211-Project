package com.iub.summitpower.features.project_manager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProjectListViewController {


    @FXML
    public TableColumn<?, ?> budgetCol;

    @FXML
    public Button changeContractButton;

    @FXML
    public TableColumn<?, ?> deadlineCol;

    @FXML
    public Button detailsButton;

    @FXML
    public Button filterProjectsButton;

    @FXML
    public Label idleTaskLabel;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public Label ongoingProjectLabel;

    @FXML
    public Label ongoingTasksLabel;

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
    public void onChangeStatusClick(ActionEvent event) {

    }

    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void onFilterClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
