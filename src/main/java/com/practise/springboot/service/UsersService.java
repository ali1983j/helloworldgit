package com.practise.springboot.service;

import com.practise.springboot.controller.ResponseEntity;
import com.practise.springboot.controller.dto.Users;
import com.practise.springboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 28/12/17.
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;



    public ResponseEntity<Users> create(Users users){

        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

        users.setPassword(cryptPasswordEncoder.encode(users.getPassword()));
        ResponseEntity<Users> response = new ResponseEntity<>(usersRepository.save(users));
        return response;
    }

    public ResponseEntity<List<Users>> findAll(){
        List<Users> lst = new ArrayList<Users>();
      ResponseEntity<List<Users>> responseEntity =  new ResponseEntity<>();
      Iterable<Users> iterable = usersRepository.findAll();

        iterable.forEach(lst :: add);

        responseEntity.setResults(lst);
      return responseEntity;
    }


}
