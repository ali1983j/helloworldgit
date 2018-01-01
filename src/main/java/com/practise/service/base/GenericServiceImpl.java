package com.practise.service.base;

import com.practise.converter.base.BaseBeanConverter;
import com.practise.orm.entity.security.audit.BaseEntity;
import com.practise.springboot.response.Message;
import com.practise.springboot.response.MessageType;
import com.practise.springboot.response.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mohammed Shoukath Ali on 31/12/17.
 */

@Transactional
public class GenericServiceImpl<E, M, ID extends Serializable> implements GenericService<M, ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public JpaRepository<E, ID> repository;
    public BaseBeanConverter<E, M> converter;

    public GenericServiceImpl(JpaRepository<E, ID> repository, BaseBeanConverter<E, M> converter){
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    public ResponseEntity<M> save(M dto) {
        try {
            E entity = this.converter.convertFrom(dto);

            entity = this.repository.saveAndFlush(entity);
            dto = this.converter.convertTo(entity);

            return new ResponseEntity<>(dto);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(), e);
            return new ResponseEntity<>().withErrors(true).withMessage(new Message(MessageType.ERROR, "" , e.getLocalizedMessage()));
        }
    }

    @Override
    public ResponseEntity<List<M>> saveAndFlush(List<M> dtos) {
        try {
            List<E> entities = this.repository.save(converter.convertFromList(dtos));
            dtos = this.converter.convertToList(entities);
            return new ResponseEntity<>(dtos);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return new ResponseEntity<>().withErrors(true).withMessage(new Message(MessageType.ERROR, "", e.getLocalizedMessage()));
        }
    }

    @Override
    public ResponseEntity saveEntity(BaseEntity entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity<M> findById(ID id) {
        try {
            E entity = this.repository.findOne(id);
            M dto = this.converter.convertTo(entity);
            return new ResponseEntity<M>().withResults(dto);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return new ResponseEntity<>().withErrors(true).withMessage(new Message(MessageType.ERROR, "", e.getLocalizedMessage()));
        }
    }

    @Override
    public ResponseEntity<?> createErrorResponse(Message message) {
        return new ResponseEntity<>().withErrors(true).withMessage(message);
    }

    @Override
    public ResponseEntity createResponse(M dto) {
        return new ResponseEntity<>(dto);
    }

    @Override
    public ResponseEntity<List<M>> createResonse(List<M> dtos) {
        return new ResponseEntity<>(dtos);
    }

    @Override
    public ResponseEntity<?> createErrorResponse(List<Message> list) {
        return new ResponseEntity<>().withErrors(true).withMessages(list);
    }

    @Override
    public ResponseEntity<List<M>> saveAllEntities(List list) {
        return null;
    }
}
