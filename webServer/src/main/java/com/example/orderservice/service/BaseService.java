package com.example.orderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
