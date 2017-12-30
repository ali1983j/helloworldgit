package com.practise.schema.beans;

import java.io.Serializable;

/**
 * Created by Mohammed Shoukath Ali on 30/12/17.
 */
public class PkEntityBase  implements Serializable{

    protected String id;

    protected Boolean inactive;
    protected Boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }



}
