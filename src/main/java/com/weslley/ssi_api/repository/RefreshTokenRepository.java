package com.weslley.ssi_api.repository;

import com.weslley.ssi_api.model.RefreshTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenModel,Long> {
    Optional<RefreshTokenModel> findByRefreshToken(String refreshToken);
}
