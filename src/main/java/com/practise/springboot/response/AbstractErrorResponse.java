package com.practise.springboot.response;

import com.practise.springboot.response.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 26/12/17.
 */
public class AbstractErrorResponse implements Serializable {


    private boolean errors;
    private List<Message> messages = new ArrayList();

    public AbstractErrorResponse(){
    }

    public AbstractErrorResponse(boolean errors, List<Message>  messages){

        this.messages = messages;
        this.errors = errors;

    }


    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
