package com.practise.orm.entity.security.audit;

import com.practise.orm.entity.security.Users;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.persistence.*;
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

    private Boolean inactive;
    private Boolean deleted;
    private Integer lockVersion;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = true)
    private Users owner;

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

    public Integer getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
