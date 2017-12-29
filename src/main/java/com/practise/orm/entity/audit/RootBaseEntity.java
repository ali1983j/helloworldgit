package com.practise.orm.entity.audit;


import javax.persistence.MappedSuperclass;

/**
 * Created by root on 29/12/17.
 *
 * @Mohammed Shoukath Ali
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class RootBaseEntity  extends AbstractAuditable<String, String>{



}
