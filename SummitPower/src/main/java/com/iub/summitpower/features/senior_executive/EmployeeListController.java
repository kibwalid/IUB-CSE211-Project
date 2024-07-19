package com.iub.summitpower.features.senior_executive;

import java.net.URL;
import java.util.ResourceBundle;

import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.features.senior_executive.models.EmployeeDTO;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeListController {


    @FXML
    public Button addEmployeeButton;

    @FXML
    public Button backButton;



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
    public TableColumn<EmployeeDTO, Button> actionCol;


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



    public void onAddEmployeeBtn(ActionEvent event) {

    }

}
