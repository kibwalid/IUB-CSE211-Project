package com.iub.summitpower.features.project_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateProjectViewController {

    @FXML
    public Button addEngineerButton;

    @FXML
    public Label availableBudgetLabel;

    @FXML
    public TextField costTextField;

    @FXML
    public Button createProjectButton;

    @FXML
    public DatePicker deadlineDatePicker;

    @FXML
    public TextArea descriptionTextArea;

    @FXML
    public ComboBox<?> employeeDropdown;

    @FXML
    public TableView<?> employeeTableView;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public TextField nameTextField;

    @FXML
    public Label ongoingProjectsLabel;

    @FXML
    public TableColumn<?, ?> phoneNumberCol;

    @FXML
    public TableColumn<?, ?> positionCol;

    @FXML
    public TextField signatureTextField;

    @FXML
    public Label userPositionLabel1;

    @FXML
    public Label userPositionLabel11;

    @FXML
    public Label userPositionLabel111;


    @FXML
    public void initialize() {

    }

    @FXML
    public void onAddEngineerClick(ActionEvent event) {

    }

    @FXML
    public void onCreateProjectClick(ActionEvent event) {

    }

    @FXML
    public void onDeadlineSelect(ActionEvent event) {

    }

}
