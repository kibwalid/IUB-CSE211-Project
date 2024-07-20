package com.iub.summitpower.features.senior_executive;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.models.EmployeeDetailsDTO;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeDetailsViewController extends NavigationHelper {


    @FXML
    public Label addedByLabel;

    @FXML
    public TextArea employeeDetailsTextArea;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField signatureLabel;

    @FXML
    public TextArea workHistoryTextArea;

    @FXML
    public Button endContractButton;



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
                addedByLabel.setText(employeeDetails.getAuditInformation());
                signatureLabel.setText(employeeDetails.getSignature());
            }
        }
    }

    @FXML
    public void onBackButton(ActionEvent event) {
        navigateToPage(goBackButton, Screens.viewAllEmployee);
    }

    public void onEndContractClicked(ActionEvent event) throws IOException {
        if(ViewControlUtils.showOptionsAlert("Are you sure you want to remove this user from the company?")) {
            if(SeniorExecutiveServicesImpl.selectedEmployeeBySE != null) {
                boolean delete = userServices.deleteUser(SeniorExecutiveServicesImpl.selectedEmployeeBySE.getUserName(),
                        SeniorExecutiveServicesImpl.selectedEmployeeBySE.getUserType());
                if(delete) {
                    SeniorExecutiveServicesImpl.selectedEmployeeBySE = null;
                    Screens.refreshScreens();
                    navigateToPage(endContractButton, Screens.viewAllEmployee);
                }
            } else {
                ViewControlUtils.showAlert("There has been an error. Please contact Khalid!");
            }
        }
    }
}
