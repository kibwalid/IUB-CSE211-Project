package com.iub.summitpower.features.hr_executive;

import java.net.URL;
import java.util.ResourceBundle;

import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RequestedTasksViewController {

    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;

    @FXML
    public Button approveButton;

    @FXML
    public Label employeeContactLabel;

    @FXML
    public Button employeeDetailsButton;

    @FXML
    public Label employeeNameLabel;

    @FXML
    public Label employeePositonLabel;

    @FXML
    public TableView<?> employeeTableView;

    @FXML
    public TextArea feedbackTextArea;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public TableColumn<?, ?> phoneNumberCol;

    @FXML
    public TableColumn<?, ?> positionCol;

    @FXML
    public Label projectAssignedLabel;

    @FXML
    public Label projectAssignedNumLabel;

    @FXML
    public Button rejectButton;

    @FXML
    public TableColumn<?, ?> salaryCol;

    @FXML
    public TextField signatureTextField;

    @FXML
    public Label taskCompletedLabel;

    @FXML
    public Label taskCompletedNumLabel;

    @FXML
    public Label notSelectedLabel;

    @FXML
    public Button viewTaskDescriptionButton;

    @FXML
    public void onViewTaskDescriptionClick(ActionEvent event) {

    }

    @FXML
    public void onApproveClick(ActionEvent event) {

    }

    @FXML
    public void onEmployeeDetailsClick(ActionEvent event) {

    }

    @FXML
    public void onRejectClick(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        notSelectedLabel.setText("You have yet to select any employee to check details of." +
                " Please follow the appropriate guidelines to check employee Information.");

        employeeNameLabel.setText("");
        employeePositonLabel.setText("");
        employeeContactLabel.setText("");
        projectAssignedLabel.setText("");
        projectAssignedNumLabel.setText("");
        taskCompletedLabel.setText("");
        taskCompletedNumLabel.setText("");
    }

    private void addEmployeeInfo(EmployeeDTO employeeDTO) {
        notSelectedLabel.setText("");

        employeeNameLabel.setText(employeeDTO.getName());
        employeePositonLabel.setText(employeeDTO.getPosition());
        employeeContactLabel.setText(employeeDTO.getPhoneNumber());

        projectAssignedLabel.setText("Project Assigned :");
        projectAssignedNumLabel.setText("0");
        taskCompletedLabel.setText("Tasks Completed :");
        taskCompletedNumLabel.setText("0");

    }

}

