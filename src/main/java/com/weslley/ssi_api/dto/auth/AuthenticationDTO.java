package com.weslley.ssi_api.dto.auth;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class AuthenticationDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String password;
}