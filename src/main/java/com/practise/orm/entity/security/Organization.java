package com.practise.orm.entity.security;

import com.practise.orm.entity.security.audit.TenantBaseEntity;

import javax.persistence.Entity;

/**
 * @author Mohammed Shoukath Ali
 */
@Entity
public class Organization  extends TenantBaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
