package com.practise.orm.entity.audit;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.UUID;

/**
 * @author Moyhammed Shoukath Ali
 *
 *
 *
 *
 */
@MappedSuperclass
public class BaseEntity extends RootBaseEntity{

    private String uuid = null;

    @PrePersist
    @PreUpdate
    public void preMerge() {

        if (StringUtils.isEmpty(this.uuid)) {
            this.uuid = UUID.randomUUID().toString();

        }

        if (this.getCreatedDate() == null) {
            setCreatedDate(new DateTime());
        }

        if (StringUtils.isEmpty(getId())) {
            setId(UUID.randomUUID().toString());
        }


    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
