package com.iub.summitpower.features.hr_executive;

import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.hr_executive.models.MessageDTO;
import com.iub.summitpower.features.hr_executive.services.HRExecutiveServicesImpl;
import com.iub.summitpower.features.hr_executive.services.IMessageServices;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MessageViewController extends NavigationHelper {


    @FXML
    public TableView<MessageDTO> messageTableView;
    @FXML
    public TableColumn<MessageDTO, String> subjectCol;
    @FXML
    public TableColumn<MessageDTO, String> sentPersonPositionCol;
    @FXML
    public TableColumn<MessageDTO, String> sentFromCol;
    @FXML
    public TableColumn<MessageDTO, String> dateCol;
    @FXML
    public TableColumn<MessageDTO, String> readCol;


    @FXML
    public Button onlyUnreadButton;
    @FXML
    public Button detailsButton;
    @FXML
    public Button toggleSendReceiveButton;


    @FXML
    public Label unreadCountLabel;
    @FXML
    public Label sentCountLabel;


    private final IMessageServices messageServices = new HRExecutiveServicesImpl();

    @FXML
    public void initialize() {
        unreadCountLabel.setText(String.valueOf(messageServices.unreadMessageNum()));
        sentCountLabel.setText(String.valueOf(messageServices.totalSentMessages()));

        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        sentFromCol.setCellValueFactory(new PropertyValueFactory<>("sentFrom"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        sentPersonPositionCol.setCellValueFactory(new PropertyValueFactory<>("senderPosition"));
        readCol.setCellValueFactory(new PropertyValueFactory<>("unread"));

        messageTableView.getItems().addAll(messageServices.getAllReceivedMessages());
    }


    @FXML
    public void onDetailsButtonClicked(ActionEvent event) {
        MessageDTO selected = messageTableView.getSelectionModel().getSelectedItem();

        if(selected != null) {
            HRExecutiveServicesImpl.selectedMessage = selected;
            messageServices.giveReadStatus(selected);
            // navigateToPage();
        } else {
            ViewControlUtils.showAlert("Please select an entry to open message!");
        }

    }

    @FXML
    public void onOnlyUnreadClicked(ActionEvent event) {
        for (MessageDTO messageDTO : messageTableView.getItems()) {
            // remove all doesn't seem to work properly. shame on you javaFX
            messageTableView.getItems().remove(messageDTO);
        }
        messageTableView.getItems().addAll(messageServices.getOnlyUnreadReceivedMessages());
    }

    @FXML
    public void onSendReceivedToggleClicked(ActionEvent event) {
        for (MessageDTO messageDTO : messageTableView.getItems()) {
            messageTableView.getItems().remove(messageDTO);
        }
        if(toggleSendReceiveButton.getText().contains("Sent")) {
            messageTableView.getItems().addAll(messageServices.getAllSentMessages());
        } else {
            messageTableView.getItems().addAll(messageServices.getAllReceivedMessages());
        }
    }


}
