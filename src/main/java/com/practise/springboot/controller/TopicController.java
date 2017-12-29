//package com.practise.springboot.controller;
//
//import com.practise.orm.entity.Topic;
//import com.practise.springboot.response.ResponseEntity;
//import com.practise.springboot.service.TopicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Created by root on 26/12/17.
// */
//
//@RestController
//public class TopicController {
//
//    @Autowired
//    private TopicService topicService;
//
//    @RequestMapping("/topics")
//    public ResponseEntity<List<Topic>> getAllTipics(){
//
//        return topicService.getAllTopics();
//
//    }
//
//    @RequestMapping("/topics/{id}")
//    public ResponseEntity<Topic> getTopic(@PathVariable("id") String id){
//        return topicService.getTopic(id);
//
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/topics")
//    public void addTopic(@RequestBody Topic topic){
//
//        topicService.addTopic(topic);
//
//    }
//}
