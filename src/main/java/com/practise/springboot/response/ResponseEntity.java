package com.practise.springboot.response;

import java.io.Serializable;

/**
 * Created by root on 26/12/17.
 */
public class ResponseEntity<T> implements Serializable {


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



}
