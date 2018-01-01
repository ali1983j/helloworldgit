package com.sky.converter.exception;

import com.practise.springboot.response.Message;

import java.util.List;

/**
 * Created by Mohammed Shoukath Ali on 31/12/17.
 */
public class SkyRuntimeException extends  RuntimeException{

    public SkyRuntimeException(String message){
        super(message);
    }

    public static SkyRuntimeException getInstance(List<Message> messages){
        StringBuffer sb = new StringBuffer();

        for (Message m : messages) {
            sb.append(m).append(" ");
        }
        return  new SkyRuntimeException(sb.toString());
    }
}
