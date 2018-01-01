package com.practise.service.base;

import com.practise.orm.entity.security.audit.BaseEntity;
import com.practise.springboot.response.Message;
import com.practise.springboot.response.ResponseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mohammed Shoukath Ali on 31/12/17.
 *
 * @param <M> - model
 * @param <ID> - Pk type
 *
 *
 */
public interface GenericService<M, ID extends Serializable> {

    /**
     * saves object
     * @param dto
     *
     */

    public ResponseEntity<M>  save(M dto);

    /**
     * @param dtos
     *
     */
    public ResponseEntity<List<M>> saveAndFlush(List<M> dtos);

    /**
     * @param entity
     *
     */
    public ResponseEntity<M>  saveEntity(BaseEntity entity);

    /**
     * @param entities
     */
    public ResponseEntity<List<M>> saveAllEntities(List<BaseEntity> entities);

    /**
     * @param dto
     *
     *
     */

    public ResponseEntity<?> delete(M dto);


    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<M> findById(ID id);

//    public void reindex();
//
//    public void reindex(String id);

    /**
     * Helper method create error response
     *
     * @param message
     * @return
     *
     */
    public ResponseEntity<?> createErrorResponse(Message message);

    /**
     * @param messages
     * @return
     */

    public ResponseEntity<?> createErrorResponse(List<Message> messages);

    /**
     * @param dto
     * @return
     */
    public ResponseEntity<M> createResponse(M dto);

    /**
     *
     * @param dtos
     * @return
     */
    public ResponseEntity<List<M>> createResonse(List<M> dtos);





}
