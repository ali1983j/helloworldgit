package com.practise.springboot.controller;

import com.practise.springboot.response.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 26/12/17.
 */
@RestController
public class HelloController {




    @RequestMapping("/hello")
    public ResponseEntity<String> sayHi(){

        return new ResponseEntity("Hello");

    }

}
