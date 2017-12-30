package com.practise.orm.entity.security;

import com.practise.orm.entity.security.audit.TenantBaseEntity;

import javax.persistence.Entity;

/**
 * Created by Mohammed Shoukath Ali
 */
@Entity
public class Profile extends TenantBaseEntity{

    private String name;

    private Boolean defaultProfile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
