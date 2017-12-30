package com.practise.springboot.controller;

import com.practise.schema.security.Users;
import com.practise.springboot.response.ResponseEntity;
import com.practise.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 26/12/17.
 */

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/users")
    public ResponseEntity<List<Users>> getAll(){
        return usersService.findAll();
    }

//    @RequestMapping("/topics/{id}")
//    public ResponseEntity<Topic> getTopic(@PathVariable("id") String id){
//        return topicService.getTopic(id);
//
//    }

//    @RequestMapping(method = RequestMethod.POST, value = "/users")
//    public void addUser(@RequestBody Users users){
//        usersService.create(users);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/users")
//    public void updateUsers(@RequestBody Users users){
//        usersService.create(users);
//    }
}
