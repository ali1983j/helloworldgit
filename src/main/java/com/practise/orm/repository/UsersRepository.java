package com.practise.orm.repository;

import com.practise.orm.entity.security.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root on 27/12/17.
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {


    Users findByUsername(String username);

    public List<Users> findByEmailAndTenantName(String email, String tenantName);




}
