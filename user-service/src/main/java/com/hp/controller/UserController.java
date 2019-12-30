package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController//controller+requsebody
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    private RestOperations restTemplate;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id)  {

//        Thread.sleep(4000);
        return this.userService.queryById(id);
    }
}
