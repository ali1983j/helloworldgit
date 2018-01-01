/* COPYRIGHT (C) 2015 DCHQ. All Rights Reserved. */
package com.practise.schema.security;

import com.practise.schema.beans.TenantEntityBase;

import java.util.*;

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
    private Boolean enabled;

    private List<String> authorities;


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAuthorities() {
        if (authorities == null) {
            authorities = new ArrayList<String>();
        }
        return this.authorities;
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

    public Users withAuthorities(String... values) {
        if (values != null) {
            for (String value : values) {
                getAuthorities().add(value);
            }
        }
        return this;
    }

    public Users withAuthorities(Collection<String> values) {
        if (values != null) {
            getAuthorities().addAll(values);
        }
        return this;
    }

    public Users withInactive(boolean value) {
        setInactive(value);
        return this;
    }

    public Users withDeleted(boolean value) {
        setDeleted(value);
        return this;
    }
}
