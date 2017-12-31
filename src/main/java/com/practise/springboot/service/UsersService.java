package com.practise.springboot.service;

import com.practise.converter.security.UsersConverter;
import com.practise.springboot.response.ResponseEntity;
import com.practise.orm.entity.security.Users;
import com.practise.orm.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 28/12/17.
 */
@Service
@Transactional
public class UsersService {

    private UsersRepository usersRepository;
    private UsersConverter usersConverter;

    @Autowired
    public UsersService(UsersRepository usersRepository, UsersConverter converter){
        this.usersRepository = usersRepository;
        this.usersConverter = converter;
    }
    public ResponseEntity<Users> create(Users users){

        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

        users.setPassword(cryptPasswordEncoder.encode(users.getPassword()));
        ResponseEntity<Users> response = new ResponseEntity<>(usersRepository.save(users));
        return response;
    }

    public ResponseEntity<Users> update(Users users){

        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

        users.setPassword(cryptPasswordEncoder.encode(users.getPassword()));
        ResponseEntity<Users> response = new ResponseEntity<>(usersRepository.saveAndFlush(users));
        return response;
    }


    public ResponseEntity<List<com.practise.schema.security.Users>> findAll(){
        List<com.practise.schema.security.Users> lst = new ArrayList<>();
      ResponseEntity<List<com.practise.schema.security.Users>> responseEntity =  new ResponseEntity<>();
        List<Users> all = usersRepository.findAll();
        List<com.practise.schema.security.Users> iterable = usersConverter.convertToList(all);

       // iterable.forEach(lst :: add);

        responseEntity.setResults(iterable);
      return responseEntity;
    }


}
