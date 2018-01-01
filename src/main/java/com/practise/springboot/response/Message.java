package com.practise.springboot.response;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Mohammed Shoukath Ali on 26/12/17.
 */
public class Message {

    private MessageType messageType;
    private String messageText;
    private String messageKey;

    public Message(MessageType type, String messageKey, String messageText){
        this.messageType = type;
        this.messageKey = messageKey;
        this.messageText = messageText;
    }


    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public Message withMessageType(MessageType messageType) {
        setMessageType(messageType);
        return this;
    }

    public Message withMessageKey(String messageKey) {
        setMessageKey(messageKey);
        return this;
    }

    public Message withMessageText(String messageText) {
        setMessageText(messageText);
        return this;
    }

    @Override
    public String toString() {
        return "Message{" + "messageType=" + messageType + ", messageKey=" + messageKey + ", messageText=" + messageText + '}';
    }

}
