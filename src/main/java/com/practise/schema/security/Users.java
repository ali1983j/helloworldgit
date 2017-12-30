/* COPYRIGHT (C) 2015 DCHQ. All Rights Reserved. */
package com.practise.schema.security;

import com.practise.orm.entity.security.Organization;
import com.practise.orm.entity.security.Profile;
import com.practise.orm.entity.security.audit.TenantBaseEntity;
import com.practise.schema.beans.TenantEntityBase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mohammed Shoukath Ali
 */


public class Users extends TenantEntityBase {


    private static final long serialVersionUID = -2116108696718738227L;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String enabled;

    private Set<String> authorities = new HashSet<>();


    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
