package com.practise.springboot.repository;

import com.practise.springboot.controller.dto.Topic;
import com.practise.springboot.controller.dto.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by root on 27/12/17.
 */

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {


    Users findByUsername(String username);




}
