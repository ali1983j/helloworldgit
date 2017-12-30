package com.practise.orm.entity.security.audit;

import com.practise.orm.entity.security.Tenant;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *@author Mohammed Shoukath Ali
 */

@MappedSuperclass
public class TenantBaseEntity extends BaseEntity{


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    private Tenant tenant;
}
