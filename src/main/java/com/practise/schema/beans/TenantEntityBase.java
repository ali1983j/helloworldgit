package com.practise.schema.beans;

/**
 * Created by Mohammed Shoukath Ali on 30/12/17.
 */
public class TenantEntityBase extends BaseEntityAudit{

    protected  NameEntityBase tenant;

    public NameEntityBase getTenant() {
        return tenant;
    }

    public void setTenant(NameEntityBase tenant) {
        this.tenant = tenant;
    }
}
