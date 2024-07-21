package com.iub.summitpower.core.entities.fucntional;

import java.util.List;

public class MessageHistory extends BaseFunctional {

    public final static String ENTITY_NAME = "MessageHistory";

    private List<Message> sentMessages;
    private List<Message> receivedMessages;

    public MessageHistory() {
        super();
    }

    public MessageHistory(int id, List<Message> sentMessages, List<Message> receivedMessages) {
        super(id, ENTITY_NAME);
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
    }

    public void addSentMessage(Message message) {
        this.sentMessages.add(message);
    }

    public void addReceivedMessage(Message message) {
        this.receivedMessages.add(message);
    }

    public void removeSentMessage(Message message) {
        this.sentMessages.remove(message);
    }

    public void removeReceivedMessage(Message message) {
        this.sentMessages.remove(message);
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
}
