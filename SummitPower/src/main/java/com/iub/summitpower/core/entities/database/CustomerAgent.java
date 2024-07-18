package com.iub.summitpower.core.entities.database;

import com.iub.summitpower.core.entities.fucntional.Contract;
import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.WorkHistory;
import com.iub.summitpower.core.enums.UserType;

import java.util.List;

public class CustomerAgent extends BaseUser{

    public final static String ENTITY_NAME = "CustomerAgent";
    private List<Message> messages;
    private List<Contract> contracts;

    public CustomerAgent() {
        super();
    }

    public CustomerAgent(int id, String name, String username, String password, String email, String phoneNumber, String position, UserType userType, List<Message> messages, List<Contract> contracts) {
        super(id, ENTITY_NAME, name, username, password, email, phoneNumber, position, userType);
        this.messages = messages;
        this.contracts = contracts;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

