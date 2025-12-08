package com.weslley.ssi_api.dto.user;

import com.weslley.ssi_api.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private UserRole role;
}
