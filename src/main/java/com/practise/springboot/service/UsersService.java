package com.practise.springboot.service;



import com.practise.schema.security.Users;
import com.practise.service.base.GenericService;
import com.practise.springboot.response.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import com.sky.service.util.SecurityRoles.*;

import java.util.List;

import static com.sky.service.util.SecurityRoles.ROLE_USER;

/**
 * Created by Mohammed Shoukath Ali on 28/12/17.
 */

public interface UsersService extends GenericService<Users, String> {


    @Secured({ROLE_USER})
    public ResponseEntity<Users> findByPkId(String id);
    @Secured({ROLE_USER})
    public ResponseEntity<Users> create(Users users);
    @Secured({ROLE_USER})
    public ResponseEntity<Users> update(Users users);
    @Secured({ROLE_USER})
    public ResponseEntity<List<Users>> findAllEntitled();
    public ResponseEntity<Users> signup(Users users);


}
