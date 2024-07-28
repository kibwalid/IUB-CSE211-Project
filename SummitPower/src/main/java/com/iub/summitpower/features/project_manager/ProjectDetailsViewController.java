package com.iub.summitpower.features.project_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ProjectDetailsViewController {


    @FXML
    public Label addedByLabel;

    @FXML
    public Label addedByLabel11;

    @FXML
    public TableColumn<?, ?> assignedEngineerCol;

    @FXML
    public TableColumn<?, ?> deadlineCol;

    @FXML
    public Label deadlineLabel;

    @FXML
    public TableColumn<?, ?> empNameCol;

    @FXML
    public TableColumn<?, ?> empPositionCol;

    @FXML
    public TableView<?> enginnersTableView;

    @FXML
    public Button goBackButton;

    @FXML
    public TableColumn<?, ?> phoneNumberCol;

    @FXML
    public Label projectCostLabel;

    @FXML
    public TextArea projectInfoTextArea;

    @FXML
    public Button projectSettingsButton;

    @FXML
    public Label projectStatusLabel;

    @FXML
    public TableColumn<?, ?> statusCol;

    @FXML
    public TableColumn<?, ?> taskNameCol;

    @FXML
    public TableView<?> taskTableView;

    @FXML
    public void onBackButton(ActionEvent event) {

    }

    @FXML
    public void onProjectSettingsClick(ActionEvent event) {

    }

    @FXML
    public void initialize() {


    }

}
