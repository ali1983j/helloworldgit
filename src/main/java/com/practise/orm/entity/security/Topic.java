package com.practise.orm.entity.security;

import com.practise.orm.entity.security.audit.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by root on 26/12/17.
 */

@Entity
public class Topic extends BaseEntity{


    private String name;
    private String description;



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
