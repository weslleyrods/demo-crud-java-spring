package com.weslley.demo_crud.controller;

import com.weslley.demo_crud.dto.auth.AuthenticationDTO;
import com.weslley.demo_crud.dto.auth.LoginResponseDTO;
import com.weslley.demo_crud.infra.security.TokenService;
import com.weslley.demo_crud.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var user = (UserModel) auth.getPrincipal();
        var token = tokenService.generateToken(user);
        return  ResponseEntity.ok(new LoginResponseDTO(token));

    }

}
