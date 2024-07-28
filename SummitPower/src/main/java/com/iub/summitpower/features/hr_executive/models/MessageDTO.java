package com.iub.summitpower.features.hr_executive.models;

import com.iub.summitpower.core.entities.database.BaseUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageDTO {

    private int messageId;
    private String subject;
    private String message;
    private String sentFrom;

    private String date;
    private String senderPosition;
    private String unread;

    public MessageDTO(int messageId, String subject, String message, String sentFrom, String senderPosition, LocalDateTime date, boolean isRead) {
        this.messageId = messageId;
        this.subject = subject;
        this.message = message;
        this.sentFrom = sentFrom;
        this.date = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.senderPosition = senderPosition;
        this.unread = isRead ? "No" : "Yes";
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSenderPosition() {
        return senderPosition;
    }

    public void setSenderPosition(String senderPosition) {
        this.senderPosition = senderPosition;
    }

    public String getUnread() {
        return unread;
    }

    public void setUnread(String unread) {
        this.unread = unread;
    }
}
