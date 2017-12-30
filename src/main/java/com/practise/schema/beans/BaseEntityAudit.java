package com.practise.schema.beans;

import org.joda.time.DateTime;

/**
 * Created by root on 30/12/17.
 */
public class BaseEntityAudit extends PkEntityBase{


    protected Integer lockVersion;
    protected DateTime lastModifiedDate;
    protected String lastModifiedBy;
    protected DateTime createdDate;
    protected UserNameEntityBase owner;



    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserNameEntityBase getOwner() {
        return owner;
    }

    public void setOwner(UserNameEntityBase owner) {
        this.owner = owner;
    }
}
