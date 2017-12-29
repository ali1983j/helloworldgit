package com.practise.springboot.controller.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by root on 26/12/17.
 */

@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;

    private String topic;

    public Topic(){}

    public Topic(String id, String name, String description){
        super();
        this.id =id;
        this.name = name;
        this.description = description;

    }



    public Topic(String topic){
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
