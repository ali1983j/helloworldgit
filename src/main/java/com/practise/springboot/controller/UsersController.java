package com.practise.springboot.controller;

import com.practise.schema.security.Users;
import com.practise.springboot.response.ResponseEntity;
import com.practise.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.practise.springboot.controller.AbstractBaseController.USERS;

/**
 * Created by Mohammed Shoukath Ali on 26/12/17.
 */

@RestController
@RequestMapping(USERS)
public class UsersController extends AbstractBaseController {

    @Autowired
    private UsersService usersService;

    private final static String USERS_SIGNUP = SLASH + "sign-up";

    @RequestMapping("/users")
    public ResponseEntity<List<Users>> getAll(){
        return usersService.findAllEntitled();
    }

    @RequestMapping(value = FIND_BY_ID_REQUEST, method = RequestMethod.GET)
    public ResponseEntity<Users> getTopic(@PathVariable("id") String id){
        return usersService.findByPkId(id);

    }

    @RequestMapping(value = CREATE_REQUEST , method = RequestMethod.POST)
    public void addUser(@RequestBody Users users){
        usersService.create(users);
    }

    @RequestMapping(value = UPDATE_REQUEST,  method = RequestMethod.PUT)
    public void updateUsers(@RequestBody Users users){
        usersService.create(users);
    }

    @RequestMapping(value = USERS_SIGNUP, method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Users> signup(@RequestBody Users users){

        logger.info("Personal account signup [{}]", users.getUsername());
        return usersService.signup(users);
    }
}
