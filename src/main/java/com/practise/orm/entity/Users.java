/* COPYRIGHT (C) 2015 DCHQ. All Rights Reserved. */
package com.practise.orm.entity;

import com.practise.orm.entity.audit.BaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mohammed Shoukath Ali
 */

@Entity
@Table
public class Users extends BaseEntity {


    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    @ElementCollection
    private Set<String> authorities = new HashSet<>();

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
