package com.weslley.demo_crud.service;
import com.weslley.demo_crud.model.UserModel;
import com.weslley.demo_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel user){
        return userRepository.save(user);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

}
