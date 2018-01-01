package com.practise.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mohammed Shoukath Ali on 31/12/17.
 */
public abstract  class AbstractBaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());


    public final static String SLASH = "/";
    public final static String VERSION = "";
    public final static String BASE =  SLASH + "api" + VERSION;

    public static final String BASE_REQUEST_PATH = BASE;

    public static final String USERS = BASE_REQUEST_PATH + SLASH + "users";


    public static final String VAR_ID = "{id}";



    //CRUD OPERATIONS
    public static final String FIND_BY_ID_REQUEST = SLASH + VAR_ID;
    public static final String CREATE_REQUEST = "";
    public static final String UPDATE_REQUEST = SLASH + VAR_ID;
}
