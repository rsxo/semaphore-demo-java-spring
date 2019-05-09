package com.example.springpipelinedemo.controller;

import com.example.springpipelinedemo.controller.forms.SignupForm;
import com.example.springpipelinedemo.dto.UserDto;
import com.example.springpipelinedemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Rimantas Jacikevičius on 19.2.14.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class) ;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto signup(@RequestBody @Valid SignupForm signupForm) {
        log.info("User: {} - Password: {}", signupForm.email, signupForm.password);
        return userService.createUser(signupForm.email, signupForm.password);
    }

}
