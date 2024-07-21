package com.iub.summitpower.features.hr_executive.repositories;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.entities.fucntional.MessageHistory;
import com.iub.summitpower.core.repositories.BaseRepository;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.features.hr_executive.models.MessageDTO;
import com.iub.summitpower.helpers.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageRepositoryImpl extends DatabaseHelper<String, MessageHistory> implements BaseRepository<String, MessageHistory> {

    public MessageRepositoryImpl() {
        super(MessageHistory.ENTITY_NAME);
    }

    @Override
    public MessageHistory getById(String key) {
        return get(key);
    }

    @Override
    public Map<String, MessageHistory> getAllData() {
        return Map.of();
    }

    @Override
    public boolean add(MessageHistory message) {
        return add(Setup.currentUser.getUsername(), message);
    }

    @Override
    public int countAll() {
        return isEntryNull() ? 0 : get(Setup.currentUser.getUsername()).getReceivedMessages().size();
    }

    private boolean isEntryNull() {
        return get(Setup.currentUser.getUsername()) == null;
    }

    private boolean isEntryNull(String username) {
        return get(username) == null;
    }

    public int getReceivedCount() {
        return countAll();
    }

    public int getSentCount() {
        return isEntryNull() ? 0 :  get(Setup.currentUser.getUsername()).getSentMessages().size();
    }

    public boolean sendMessage(Message message) {
        String sender = message.getSentFrom().getUsername();
        String receiver = message.getSentTo().getUsername();

        boolean success = false;

        List<Message> placeHolderMessageList = new ArrayList<>();

        // message saving for sender
        if(isEntryNull(sender)) {
            message.setId(1);
            placeHolderMessageList.add(message);
            MessageHistory messageHistory = new MessageHistory(0, placeHolderMessageList, new ArrayList<>());
            success = add(sender, messageHistory);
        } else {
            MessageHistory messageHistory = get(sender);
            message.setId(messageHistory.getSentMessages().size() + 1);
            messageHistory.addSentMessage(message);
            success = update(sender ,messageHistory);
        }

        placeHolderMessageList = new ArrayList<>();
        // message saving for receiver
        if(isEntryNull(receiver)) {
            message.setId(1);
            placeHolderMessageList.add(message);
            MessageHistory messageHistory = new MessageHistory(0,  new ArrayList<>(), placeHolderMessageList);
            success = add(receiver, messageHistory) && success;
        } else {
            MessageHistory messageHistory = get(receiver);
            message.setId(messageHistory.getSentMessages().size() + 1);
            messageHistory.addReceivedMessage(message);
            success = update(receiver ,messageHistory) && success;
        }

        return success;
    }

    public boolean updateReadStatus(MessageDTO messageDTO) {
        MessageHistory history = get(Setup.currentUser.getUsername());

        List<Message> receivedMessages = history.getReceivedMessages();
        List<Message> filteredMessages = new ArrayList<>();

        for(Message message : receivedMessages) {
            if (message.getId() == messageDTO.getMessageId()) {
                message.setRead(true);
            }
            filteredMessages.add(message);
        }

        history.setReceivedMessages(filteredMessages);
        return update(Setup.currentUser.getUsername(), history);
    }

    public List<Message> getReceivedMessages() {
        if(isEntryNull()) {
            return List.of();
        }
        return get(Setup.currentUser.getUsername()).getReceivedMessages();
    }

    public List<Message> getSentMessages() {
        if(isEntryNull()) {
            return List.of();
        }
        return get(Setup.currentUser.getUsername()).getSentMessages();
    }

}
