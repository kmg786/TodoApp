package com.TodoApplication.App.Service;

import com.TodoApplication.App.Model.AppUser;
import com.TodoApplication.App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser createProfile(AppUser user) {
        AppUser newUser = new AppUser();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setCreateUser("ADMIN");
        newUser.setCreateTs(LocalDateTime.now());
        newUser.setModifyTs(LocalDateTime.now());
        newUser.setModifyUser("ADMIN");
        userRepository.save(newUser);
        return newUser;
    }
}
