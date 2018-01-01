package com.practise.springboot.response;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Shoukath Ali on 26/12/17.
 */
public class ResponseEntity<T> extends AbstractErrorResponse {


    private static final long serialVersionUID = 2631379955711104376L;
    private T results;
    private Long totalElements;
    private Integer totalPages;

    public ResponseEntity(){

    }

    public ResponseEntity(T T){
        this.results = T;

    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ResponseEntity withErrors(boolean errors){
        setErrors(errors);
        return this;
    }

    public ResponseEntity withMessage(Message m){
        if (CollectionUtils.isEmpty(this.getMessages())){
            this.setMessages(new ArrayList<Message>());
        }
        this.getMessages().add(m);
        return this;
    }

    public ResponseEntity withMessages(List<Message> messages){
        this.setMessages(messages);
        return this;
    }

    public ResponseEntity withResults(T results){
        this.setResults(results);
        return this;
    }



}
