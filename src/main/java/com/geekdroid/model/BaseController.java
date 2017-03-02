package com.geekdroid.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by james.li on 2017/3/2.
 */
public abstract class BaseController<C> {

    @Autowired
    protected C service;



}
