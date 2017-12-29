package com.practise.springboot.repository;

import com.practise.springboot.controller.dto.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by root on 27/12/17.
 */

@Repository
public interface TopicRepository  extends CrudRepository<Topic, String> {

    //getAllTopics()
    //getTopic();
    //updateTopic(_)
    //deleteTopic();





}
