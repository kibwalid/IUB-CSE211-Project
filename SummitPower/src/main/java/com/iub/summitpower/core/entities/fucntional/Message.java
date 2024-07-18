package com.iub.summitpower.core.entities.fucntional;

import com.iub.summitpower.core.entities.database.BaseEntity;
import com.iub.summitpower.core.entities.database.BaseUser;

public class Message extends BaseEntity {

    public final static String ENTITY_NAME = "Message";

    private String subject;
    private String message;
    private BaseUser sentTo;
    private BaseUser sentFrom;
    private boolean isRead;

    public Message() {
        super();
    }

    public Message(int id, String subject, String message, BaseUser sentTo, BaseUser sentFrom, boolean isRead) {
        super(id, ENTITY_NAME);
        this.subject = subject;
        this.message = message;
        this.sentTo = sentTo;
        this.sentFrom = sentFrom;
        this.isRead = isRead;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseUser getSentTo() {
        return sentTo;
    }

    public void setSentTo(BaseUser sentTo) {
        this.sentTo = sentTo;
    }

    public BaseUser getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(BaseUser sentFrom) {
        this.sentFrom = sentFrom;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
