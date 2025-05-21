package com.vaishnavi.practice.spring.boot.controller;

import com.vaishnavi.practice.spring.boot.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

}


