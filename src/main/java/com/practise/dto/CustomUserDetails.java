/* COPYRIGHT (C) 2015 DCHQ. All Rights Reserved. */
package com.practise.dto;

import com.practise.orm.entity.security.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author Mohammed Shoukath Ali
 */
public class CustomUserDetails extends User {

    private final Users user;

    public CustomUserDetails(Users user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user = user;
    }

    public CustomUserDetails(Users user, String username, String password, Boolean enabled, Boolean accountNonExpired, Boolean credentialsNonExpired, Boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

}
