package com.iub.summitpower.features.hr_executive;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PaySalaryViewController {


    @FXML
    public Label budgetLeftLabel;

    @FXML
    public TableView<?> employeeTableView;

    @FXML
    public TableColumn<?, ?> nameCol;

    @FXML
    public Button paySalaryButoon;

    @FXML
    public TableColumn<?, ?> phoneNumberCol;

    @FXML
    public TableColumn<?, ?> positionCol;

    @FXML
    public TableColumn<?, ?> salaryCol;

    @FXML
    public TextField signatureTextField;

    @FXML
    public Label unpaidAmountLabel;

    @FXML
    public void onPaySalaryClicked(ActionEvent event) {

    }

    @FXML
    public void initialize() {

    }

}
