package com.iub.summitpower.features.hr_executive.services;

import com.iub.summitpower.core.entities.fucntional.Message;
import com.iub.summitpower.features.hr_executive.models.MessageDTO;

import java.util.List;

public interface IMessageServices {
    List<MessageDTO> getAllReceivedMessages();
    List<MessageDTO> getAllSentMessages();

    boolean sendMessage(Message message);

    int totalReceivedMessages();
    int totalSentMessages();

    int unreadMessageNum();

    List<MessageDTO> getOnlyUnreadReceivedMessages();


    boolean giveReadStatus(MessageDTO selected);
}
