package com.practise.orm.entity.security;

import com.practise.orm.entity.security.audit.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Mohammed Shoukath Ali
 */

@Entity
public class Tenant extends BaseEntity{

    @Column(unique = true)
    private String name;

    private String contactEmail;

    private String contactPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
