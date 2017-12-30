package com.practise.schema.beans;

/**
 * Created by Mohammed Shoukath Ali on 30/12/17.
 */
public class NameEntityBase extends PkEntityBase{


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameEntityBase withId(String id){
        setId(id);
        return this;
    }

    public NameEntityBase withName(String name){
        setName(name);
        return this;
    }
}
