package com.practise.orm.entity.security.audit;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by root on 29/12/17.
 * <p>
 * <p>
 * <p>
 * <p>
 * Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.
 * A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity except that the mappings will apply only to its subclasses
 * since no table exists for the mapped superclass itself. When applied to the subclasses the inherited mappings will apply in the context of the subclass tables.
 * Mapping information may be overridden in such subclasses by using the AttributeOverride and AssociationOverride annotations or corresponding XML elements.

 /**
 * Abstract base class for entities. Allows parameterization of id type, chooses
 * auto-generation and implements {@link #equals(Object)} and
 * {@link #hashCode()} based on that id.
 *
 * @author Oliver Gierke
 * @param <PK> the the of the entity

 */



@MappedSuperclass
public  class AbstractPersistable<PK extends Serializable>  implements Persistable<PK>{


    private static final long serialVersionUID = -3526260351359965879L;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private PK id;

    @Override
    public PK getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id the id to set
     */
    public void setId(final PK id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return false;
    }

    /*
  * (non-Javadoc)
  *
  * @see java.lang.Object#toString()
  */
    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractPersistable<?> that = (AbstractPersistable<?>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }
}
