package com.iub.summitpower.features.hr_executive;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.models.EmployeeDetailsDTO;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PerformanceReviewController extends NavigationHelper {

    @FXML
    public Label afterIncrementLabel;

    @FXML
    public Button completeReviewButton;

    @FXML
    public Label currentSalaryLabel;

    @FXML
    public TextArea employeeDetailsTextArea;

    @FXML
    public Button goBackButton;

    @FXML
    public ComboBox<Integer> incrementComboBox;

    @FXML
    public TextArea reasonForEvalTextArea;

    @FXML
    public TextField signatureLabel;

    @FXML
    public TextArea workHistoryTextArea;

    IUserServices userServices = new SeniorExecutiveServicesImpl();


    @FXML
    public void initialize() {
        if(SeniorExecutiveServicesImpl.selectedEmployeeBySE != null) {
            EmployeeDTO selected = SeniorExecutiveServicesImpl.selectedEmployeeBySE;
            EmployeeDetailsDTO employeeDetails = userServices.getSingleEmployee(selected.getUserName(), selected.getUserType());

            if(employeeDetails != null) {
                employeeDetailsTextArea.setText(employeeDetails.getPersonalInformation());
                String workHistory = employeeDetails.getWorkHistory();
                if(workHistory.isEmpty()) {
                    workHistory = "The employee has yet to achieve greatness!";
                }
                workHistoryTextArea.setText(workHistory);
                signatureLabel.setText(employeeDetails.getSignature());

                currentSalaryLabel.setText(selected.getSalary() + " Tk");
                afterIncrementLabel.setText(selected.getSalary() + " Tk");
            }
        }
        incrementComboBox.getItems().addAll(-15, -10, 0, 10, 15, 25, 30, 35, 40, 50, 75, 100);
        incrementComboBox.setValue(0);

        incrementComboBox.setOnAction(this::onSelectValue);
    }

    private void onSelectValue(ActionEvent event) {
        double newSalary = SeniorExecutiveServicesImpl.selectedEmployeeBySE.getSalary() * ((double) incrementComboBox.getValue() / 100);
        afterIncrementLabel.setText(newSalary + " Tk");
    }


    @FXML
    public void onBackButton(ActionEvent event) {
        navigateToPage(goBackButton, Screens.hrEmployeeList);
    }

    @FXML
    public void onCompleteReviewClick(ActionEvent event) {

    }



}
