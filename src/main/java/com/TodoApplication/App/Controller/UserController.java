package com.TodoApplication.App.Controller;

import com.TodoApplication.App.Model.AppUser;
import com.TodoApplication.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public AppUser createUserProfile(@RequestBody AppUser user){
        return userService.createProfile(user);
    }
}
