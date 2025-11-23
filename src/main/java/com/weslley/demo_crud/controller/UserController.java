package com.weslley.demo_crud.controller;

import com.weslley.demo_crud.model.UserModel;
import com.weslley.demo_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel create(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @GetMapping
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserModel findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
