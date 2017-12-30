package com.practise.converter.base;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Shoukath Ali on 30/12/17.
 *
 * @param  <S> source object - Entity
 *
 * @param  <D> destination object - Dto
 */
public class BaseBeanConverter<S, D> {

    @Autowired
    protected MapperFacade mapperFacade;

    protected Class sourceClass;
    protected Class destinationClass;


    public BaseBeanConverter(Class sourceClass, Class destinationClass){
        this.sourceClass = sourceClass;
        this.destinationClass = destinationClass;
    }

    /**
     * @param source
     * @return destinationClass
     */
    public D convertTo(S source) {

        if (source == null) {
            return null;
        }

        return (D) mapperFacade.map(source, destinationClass);

    }

    /**
     *
     * @param destination
     * @return source
     */
    public S convertFrom(D destination) {

        if (destination == null) {
            return null;

        }
        return (S) mapperFacade.map(destination, sourceClass);

    }

    /**
     * @param sources
     * @return list of destination
     */

    public List<D> convertToList(List<S> sources) {
        List<D> list = new ArrayList<>();
        for (S s : sources) {
            list.add(convertTo(s));

        }
        return list;
    }

    /**
     * @return list of source
     * @param destinations of destination
     */

    public List<S> convertFromList(List<D> destinations) {
        List<S> list = new ArrayList<S>();

        for (D d : destinations) {
            list.add(convertFrom(d));

        }
        return list;
    }






}
