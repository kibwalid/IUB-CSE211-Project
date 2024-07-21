package com.iub.summitpower.features.hr_executive.services;

import com.iub.summitpower.core.entities.database.BaseUser;
import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.core.setup.Setup;
import com.iub.summitpower.core.utills.RepositoryUtils;
import com.iub.summitpower.core.utills.ViewControlUtils;
import com.iub.summitpower.features.hr_executive.models.MessageDTO;

import java.util.List;

public class HRExecutiveServicesImpl extends RepositoryUtils implements IMessageServices {

    public static MessageDTO selectedMessage = null;

    @Override
    public List<MessageDTO> getAllReceivedMessages() {
        return messageRepository.getReceivedMessages().stream()
                .map(message -> new MessageDTO(message.getId(),
                                message.getSubject(),
                                message.getMessage(),
                                message.getSentFrom().getName(),
                                message.getSentFrom().getPosition(),
                                message.getAddedAt(), message.isRead()))
                .toList();
    }

    @Override
    public List<MessageDTO> getAllSentMessages() {
        return messageRepository.getSentMessages().stream()
                .map(message -> new MessageDTO(message.getId(),
                        message.getSubject(),
                        message.getMessage(),
                        message.getSentFrom().getName(),
                        message.getSentFrom().getPosition(),
                        message.getAddedAt(), message.isRead()))
                .toList();
    }

    @Override
    public boolean sendMessage(Message message) {
        return messageRepository.sendMessage(message);
    }

    @Override
    public int totalReceivedMessages() {
        return messageRepository.getReceivedCount();
    }

    @Override
    public int totalSentMessages() {
        return messageRepository.getSentCount();
    }

    @Override
    public int unreadMessageNum() {
        int count = 0;
        for(Message message : messageRepository.getReceivedMessages()) {
            if(!message.isRead()) {
                count += 1;
            }
        }
        return count;
    }


    @Override
    public List<MessageDTO> getOnlyUnreadReceivedMessages() {
        return messageRepository.getReceivedMessages().stream()
                .filter(message -> !message.isRead()).map(message ->
                        new MessageDTO(message.getId(), message.getSubject(),
                                message.getMessage(),
                                message.getSentFrom().getName(),
                                message.getSentFrom().getPosition(),
                                message.getAddedAt(), message.isRead()))
                .toList();
    }

    @Override
    public boolean giveReadStatus(MessageDTO selected) {
        return messageRepository.updateReadStatus(selected);
    }

    @Override
    public Message validateAndProvideDTO(String subject, String message, BaseUser sendTo) {
        if(subject.isEmpty()) {
            ViewControlUtils.showAlert("Subject cannot be empty");
            return null;
        }
        if(message.isEmpty()) {
            ViewControlUtils.showAlert("Message body cannot be empty");
            return null;
        }

        if(sendTo == null) {
            ViewControlUtils.showAlert("Please select the person you want to send the message to!");
            return null;
        }

        return new Message(0, subject, message, sendTo, Setup.currentUser, false);
    }


}
