/* COPYRIGHT (C) 2015 DCHQ. All Rights Reserved. */
package com.practise.orm.entity.audit;

import com.practise.springboot.CustomUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * check https://github.com/spring-projects/spring-data-jpa-examples/blob/master/spring-data-jpa-example/src/main/java/org/springframework/data/jpa/example/repository/auditing/AuditorAwareImpl.java
 * @author Intesar Mohammed
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) obj;
            if (userDetails instanceof CustomUserDetails) {
                CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
                return customUserDetails.getUser().getUsername();
            }
        }
        return obj.toString();
    }

}
