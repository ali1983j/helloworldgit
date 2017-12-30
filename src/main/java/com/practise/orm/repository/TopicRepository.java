package com.practise.orm.repository;

import com.practise.orm.entity.security.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by root on 27/12/17.
 */

@Repository
public interface TopicRepository  extends JpaRepository<Topic, String> {

    //getAllTopics()
    //getTopic();
    //updateTopic(_)
    //deleteTopic();





}
