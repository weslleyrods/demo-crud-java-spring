package com.weslley.ssi_api.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshTokenDTO {
    private String refreshToken;
}
