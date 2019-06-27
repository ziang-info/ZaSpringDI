package info.ziang.spring.controller;

import info.ziang.spring.di.Inject;
import info.ziang.spring.service.UserService;

public class UserController {

    @Inject("UserService")
    private UserService userService;

    public void save() {
        userService.save();
    }

    public UserController() {
    }
}
