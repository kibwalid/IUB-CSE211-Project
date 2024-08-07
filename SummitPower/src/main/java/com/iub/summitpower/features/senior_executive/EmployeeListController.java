package com.iub.summitpower.features.senior_executive;

import java.io.IOException;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeListController extends NavigationHelper {


    @FXML
    public TableView<EmployeeDTO> employeeTableView;


    @FXML
    public TableColumn<EmployeeDTO, String> nameCol;

    @FXML
    public TableColumn<EmployeeDTO, String> phoneNumberCol;

    @FXML
    public TableColumn<EmployeeDTO, String> positionCol;

    @FXML
    public TableColumn<EmployeeDTO, Double> salaryCol;

    @FXML
    public TableColumn<EmployeeDTO, UserType> employeeCol;

    @FXML
    public Button endContractButton;
    @FXML
    public Button detailsButton;
    @FXML
    public Button performanceReviewButton;


    private final IUserServices userServices = new SeniorExecutiveServicesImpl();



    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        employeeCol.setCellValueFactory(new PropertyValueFactory<>("userType"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));


        employeeTableView.getItems().addAll(userServices.getAllEmployeeTableData());
    }

    public void onPerformanceReviewClick() throws IOException {
        EmployeeDTO selected = employeeTableView.selectionModelProperty().get().getSelectedItem();
        if(selected != null) {
            SeniorExecutiveServicesImpl.selectedEmployeeBySE = selected;
            Screens.refreshScreens();
            navigateToPage(performanceReviewButton, Screens.hrPerformanceReview);
        } else {
            ViewControlUtils.showAlert("Please select an entry to view details!");
        }
    }


    public void onDetailsButtonClicked(ActionEvent event) throws IOException {
        EmployeeDTO selected = employeeTableView.selectionModelProperty().get().getSelectedItem();
        if(selected != null) {
            SeniorExecutiveServicesImpl.selectedEmployeeBySE = selected;
            Screens.refreshScreens();
            if(selected.getUserType() == UserType.SENIOR_EXECUTIVE) {
                navigateToPage(detailsButton, Screens.seniorExecutiveEmployeeDetails);
            } else {
                navigateToPage(detailsButton, Screens.hrEmployeeDetails);
            }
        } else {
            ViewControlUtils.showAlert("Please select an entry to view details!");
        }
    }


    public void onEndContractClicked(ActionEvent event) {
        if(ViewControlUtils.showOptionsAlert("Are you sure you want to remove this user from the company?")) {
            EmployeeDTO selected = employeeTableView.selectionModelProperty().get().getSelectedItem();
            if(selected != null) {
                boolean delete = userServices.deleteUser(selected.getUserName(), selected.getUserType());
                if(delete) {
                    employeeTableView.getItems().remove(selected);
                }
            } else {
                ViewControlUtils.showAlert("Please select an entry to perform END CONTRACT!");
            }
        }
    }

}
