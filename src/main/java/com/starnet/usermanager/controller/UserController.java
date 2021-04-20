package com.starnet.usermanager.controller;

import com.starnet.usermanager.model.User;
import com.starnet.usermanager.repository.UserRepository;
import com.starnet.usermanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;



    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        System.out.println(user.toString());
        userRepository.save(user);
        return user;
    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody List<User> userList){
        userService.deleteUsers(userList);
    }
}












