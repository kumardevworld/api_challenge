package com.disney.studios.controller;


import com.disney.studios.models.User;
import com.disney.studios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appuser/v1/users")
public class AppUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration",
            method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public User registration(@RequestBody User user) {
    	User createdUser = this.userService.save(user);
        return createdUser;
    }




   
}