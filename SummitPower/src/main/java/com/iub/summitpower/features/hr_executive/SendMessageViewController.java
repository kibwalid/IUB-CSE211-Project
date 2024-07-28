package com.iub.summitpower.features.hr_executive;


import com.iub.summitpower.core.entities.database.BaseUser;
import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.enums.UserType;
import com.iub.summitpower.core.setup.Screens;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.hr_executive.models.UserForMessageDTO;
import com.iub.summitpower.features.hr_executive.services.HRExecutiveServicesImpl;
import com.iub.summitpower.features.hr_executive.services.IMessageServices;
import com.iub.summitpower.features.senior_executive.services.IUserServices;
import com.iub.summitpower.features.senior_executive.services.SeniorExecutiveServicesImpl;
import com.iub.summitpower.features.unlogged.login.services.LoginServicesImpl;
import com.iub.summitpower.helpers.NavigationHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendMessageViewController extends NavigationHelper {


    @FXML
    public TextArea bodyTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public ComboBox<UserForMessageDTO> sendToComboBox;

    @FXML
    public TextField subjectTextField;


    private final IUserServices userServices = new SeniorExecutiveServicesImpl();
    private final LoginServicesImpl loginServices = new LoginServicesImpl();
    private final IMessageServices messageServices = new HRExecutiveServicesImpl();

    @FXML
    public void initialize() {
        sendToComboBox.getItems().addAll(userServices.getAllEmployeeTableData()
                .stream()
                .filter(employeeDTO -> employeeDTO.getUserType() != UserType.SENIOR_EXECUTIVE
                        || employeeDTO.getUserType() != UserType.CUSTOMER_AGENT)
                .map(employeeDTO ->
                        new UserForMessageDTO(employeeDTO.getUserName(),
                                employeeDTO.getName(),
                                employeeDTO.getPosition(), employeeDTO.getUserType()))
                .toList());

    }


    @FXML
    public void onSendMessagePress(ActionEvent event) {
        BaseUser selected = loginServices.getIfUserExists(sendToComboBox.getSelectionModel().getSelectedItem().getUsername(),
                sendToComboBox.getSelectionModel().getSelectedItem().getUserType());
        if(selected == null) {
            ViewControlUtils.showAlert("Please select a recipient of your message!");
        } else {
            Message message = messageServices.validateAndProvideDTO(subjectTextField.getText(), bodyTextArea.getText(), selected);
            boolean sent = messageServices.sendMessage(message);
            if(sent) {
                ViewControlUtils.showAlert("Your message has been sent to " + sendToComboBox.getSelectionModel().getSelectedItem().toString());
                navigateToPage(sendMessageButton, Screens.hrMessages);
            }
        }
    }

}
