package com.weslley.demo_crud.service;
import com.weslley.demo_crud.model.UserModel;
import com.weslley.demo_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


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

    public UserModel findById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
    }

    public void  deleteById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
        userRepository.deleteById(id);
    }


}
