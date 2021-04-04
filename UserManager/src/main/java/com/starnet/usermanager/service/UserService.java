package com.starnet.usermanager.service;

import com.starnet.usermanager.model.User;
import com.starnet.usermanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public void deleteUsers(List<User> userList){
        List<Integer> idList = new LinkedList<>();
        for (User user : userList){
            idList.add(user.getUid());
        }
        userRepository.delete(idList);
    }
}
