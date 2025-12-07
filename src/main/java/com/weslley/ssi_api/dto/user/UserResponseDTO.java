package com.weslley.ssi_api.dto.user;

import com.weslley.ssi_api.model.UserModel;
import com.weslley.ssi_api.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private UserRole role;

    public static UserResponseDTO from(UserModel user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
