package com.practise.converter.security;

import com.practise.converter.base.BaseBeanConverter;
import com.practise.schema.security.Users;
import org.springframework.stereotype.Component;

/**
 * Created by Mohammed Shoukath Ali on 30/12/17.
 */

@Component
public class UsersConverter extends BaseBeanConverter<com.practise.orm.entity.security.Users, Users>{
    public UsersConverter() {
        super(com.practise.orm.entity.security.Users.class, Users.class);
    }
}
